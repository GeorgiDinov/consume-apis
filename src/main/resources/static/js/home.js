//Messages
const ajaxErrorMessage = "Error occurred while doing AJAX to ";
//Layout Div
const layout = document.getElementById('layout');
const buttonHolder = document.getElementById('buttonHolder');
//Buttons
const authenticationButton = document.getElementById('authenticate');
const getCountriesButton = document.getElementById('getCountries');
const getMarksButton = document.getElementById('getMarks');
const getStudentsButton = document.getElementById('getStudents');
const addStudentButton = document.getElementById('addStudent');
const clearScreenButton = document.getElementById('clearScreen');
//end of Buttons
const listHolder = document.getElementById('listHolder');

//auth status
let isAuthenticated = false;

//Api route constants
const apiUrl = 'http://localhost:8081';
const authenticationUrl = apiUrl + '/authenticate';
const getAllCountriesUrl = apiUrl + '/feign/countries/filtered';
const getAllMarksUrl = apiUrl + "/marks";
const getAllStudentsUrl = apiUrl + "/students";
//Http methods
const get = "GET";
const post = "POST";
const put = "PUT";
const del = "DELETE";

$(document).ready(function () {
    authenticationButton.addEventListener('click', performAuthentication);
    getCountriesButton.addEventListener('click', listAllCountries);
    getMarksButton.addEventListener('click', listAllMarks);
    getStudentsButton.addEventListener('click', listAllStudents)
    addStudentButton.addEventListener('click', createStudent);
    clearScreenButton.addEventListener('click', clearScreen);
});

function clearScreen(event) {
    event.preventDefault();
    emptyElement(listHolder);
}

function performAuthentication(event) {
    event.preventDefault();
    emptyElement(listHolder);

    let authPromise = $.ajax({
        method: get,
        url: authenticationUrl
    }).fail(function () {
        console.log(ajaxErrorMessage + authenticationUrl);
        drawMessage("Authentication Failure!")
    });

    authPromise.then(function () {
        isAuthenticated = true;
        drawMessage("Authentication Successful!")
    });
}

function listAllCountries(event) {
    event.preventDefault();
    emptyElement(listHolder);

    let countryListPromise = $.ajax({
        method: get,
        url: getAllCountriesUrl
    }).fail(function () {
        console.log(ajaxErrorMessage + getAllCountriesUrl);
        drawMessage("Loading Countries Failure!")
    });

    countryListPromise.then(function (data) {
        let jsonData = JSON.stringify(data);
        let countriesList = JSON.parse(jsonData);
        for (let i = 0; i < countriesList.countries.length; i++) {
            let country = countriesList.countries[i];
            drawCountry(country);
        }
    })
}

function listAllMarks(event) {
    event.preventDefault();
    emptyElement(listHolder);
    if (!isAuthenticated) {
        drawMessage("Not Authorized!")
    }
    let marksPromise = $.ajax({
        method: get,
        url: getAllMarksUrl
    }).fail(function () {
        console.log(ajaxErrorMessage + getAllMarksUrl);
        drawMessage("Loading Marks Failure!")
    });

    marksPromise.then(function (data) {
        let jsonData = JSON.stringify(data);
        let markList = JSON.parse(jsonData);
        for (let i = 0; i < 30; i++) {
            let mark = markList.marks[i];
            drawMark(mark);
        }
    });
}

function listAllStudents(event) {
    event.preventDefault();
    emptyElement(listHolder);
    if (!isAuthenticated) {
        drawMessage("Not Authorized!")
    }

    let studentListPromise = $.ajax({
        method: get,
        url: getAllStudentsUrl
    }).fail(function () {
        console.log(ajaxErrorMessage + getAllStudentsUrl);
        drawMessage("Loading Students Failure!")
    });

    studentListPromise.then(function (data) {
        let jsonData = JSON.stringify(data);
        let studentList = JSON.parse(jsonData);
        for (let i = 0; i < studentList.students.length; i++) {
            let student = studentList.students[i];
            drawStudent(student);
        }
    });

}

function createStudent(event) {
    event.preventDefault();
    emptyElement(listHolder);
    if (!isAuthenticated) {
        drawMessage("Not Authorized!")
    }
    drawStudentForm();

}


function emptyElement(element) {
    $(element).empty();
}

function drawMessage(messageText) {
    emptyElement(listHolder);

    let messageDiv = document.createElement('div');
    let message = document.createElement('div');
    let deleteMessageDiv = document.createElement('div');

    $(messageDiv).addClass('list-element');

    $(message).text(messageText).appendTo(messageDiv);

    $(deleteMessageDiv)
        .text('DELETE MESSAGE')
        .click(function () {
            emptyElement(listHolder);
        }).css({
        'cursor': 'pointer',
        'color': 'red'
    }).appendTo(messageDiv);

    $(messageDiv).appendTo(listHolder);
}


function drawCountry(country) {

    let countryDiv = document.createElement('div');

    let flagImage = document.createElement('img');
    let flag = country.flag;

    let nameDiv = document.createElement('div');
    let name = country.name;

    let capitalDiv = document.createElement('div');
    let capital = country.capital;

    $(countryDiv).addClass('list-element');

    $(flagImage).attr('src', flag);
    $(flagImage).appendTo(countryDiv);


    $(nameDiv).css({
        'flex': '2 2'
    }).text(name).appendTo(countryDiv);
    $(capitalDiv).css({
        'flex': '2 2'
    }).text(capital).appendTo(countryDiv);

    $(countryDiv).appendTo(listHolder);
}

function drawMark(mark) {
    let markDiv = document.createElement('div');
    $(markDiv).addClass('list-element');

    let markValueDiv = document.createElement('div');
    let markVal = mark.mark;

    let markDateDiv = document.createElement('div');
    let markDate = mark.date;

    let markStudentDiv = document.createElement('div');
    let markStudent = mark.student_name;

    let markCourseDiv = document.createElement('div');
    let markCourse = mark.course_name;

    $(markValueDiv).text(markVal).appendTo(markDiv);
    $(markDateDiv).text(markDate).appendTo(markDiv);
    $(markStudentDiv).text(markStudent).appendTo(markDiv);
    $(markCourseDiv).text(markCourse).appendTo(markDiv);

    $(markDiv).appendTo(listHolder);
}

function drawStudent(student) {
    let studentDiv = document.createElement('div');
    $(studentDiv).addClass('list-element');

    let studentNameDiv = document.createElement('div');
    $(studentNameDiv).text(student.student_name).appendTo(studentDiv);

    let studentUrlDiv = document.createElement('div');
    $(studentUrlDiv).text(student.student_url).appendTo(studentDiv);

    $(studentDiv).appendTo(listHolder);
}

function drawStudentForm() {
    $("<form>",
        {
            id: 'contactForm'
        }
    ).append(
        $("<input>",
            {
                id: 'studentName',
                type: 'text',
                placeholder: 'Student Full Name',
                name: 'studentName'
            }
        )
    ).append(
        $("<input>",
            {
                type: 'submit'
            })
    ).appendTo(listHolder)
        .submit(sendStudentData);
}

function sendStudentData(event) {
    event.preventDefault();

    let studentName = document.getElementById('studentName').value;

    let student = {
        "student_name": studentName
    }

    let jsonedStudent = JSON.stringify(student);

    let createdStudentPromise = $.ajax({
        method: post,
        url: getAllStudentsUrl,
        headers: {
            'Content-Type': 'application/json;charset=utf - 8'
        },
        data: jsonedStudent,
        dataType: 'JSON'
    }).fail(function () {
        console.log(ajaxErrorMessage + getAllStudentsUrl);
        drawMessage("Creating Student Failure!")
    });

    createdStudentPromise.then(function (data) {
        let jsonData = JSON.stringify(data);
        let student = JSON.parse(jsonData);
        emptyElement(listHolder);
        drawStudent(student);
    })

}