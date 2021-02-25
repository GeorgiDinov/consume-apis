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
//end of Buttons
const listHolder = document.getElementById('listHolder');

//auth status
let isAuthenticated = false;

//Api route constants
const apiUrl = 'http://localhost:8081';
const authenticationUrl = apiUrl + '/authenticate';
const getAllCountriesUrl = apiUrl + '/feign/countries/filtered';
//Http methods
const get = "GET";
const post = "POST";
const put = "PUT";
const del = "DELETE";

$(document).ready(function () {
    authenticationButton.addEventListener('click', performAuthentication);
    getCountriesButton.addEventListener('click', listAllCountries)
});

function performAuthentication(event) {
    event.preventDefault();
    let authPromise = $.ajax({
        method: get,
        url: authenticationUrl
    }).fail(function () {
        console.log(ajaxErrorMessage + authenticationUrl);
    });

    authPromise.then(isAuthenticated = true);
}

function listAllCountries(event) {
    event.preventDefault();
    if (!isAuthenticated) {
        console.log("Not Authenticated")
    }
}