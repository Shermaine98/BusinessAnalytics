/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//Setting MIN & MAX DATES FOR DATEPICKERS
//Used for Minimum date is tomorrow (in index.html, until when researchers will have access)
var today = new Date().toISOString().split('T')[0];
var tomorrowLocal = new Date(new Date().getTime() + 24 * 60 * 60 * 1000 - new Date().getTimezoneOffset() * 60 * 1000).toISOString().substr(0, 10);
document.getElementById('DateValid').setAttribute('min', tomorrowLocal);
document.getElementById('DateValid').setAttribute('value', tomorrowLocal);
document.getElementById('employmentDate').setAttribute('max', today);
document.getElementById('employmentDate').setAttribute('value', today);

/**
 * Used for researchers (others) in register
 */
function yesnoCheck(that) {
    if (that.value == "Others") {
        document.getElementById("ifYes").style.display = "block";
    } else {
        document.getElementById("ifYes").style.display = "none";
    }
}

/**
 * Date 12 yrs from now
 */
var tenYears = new Date();
tenYears.setFullYear(tenYears.getFullYear() - 12);
var dMonth = tenYears.getMonth() + 1;
var dYear = tenYears.getFullYear();
var dDay = tenYears.getDate();
var birthdate = tenYears.toISOString().substring(0,10);

document.getElementById('Birthdate').setAttribute('max', birthdate);
document.getElementById('Birthdate').value = tenYears.toISOString().substring(0,10);
