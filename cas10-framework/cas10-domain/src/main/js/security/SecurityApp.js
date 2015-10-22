var security = require('./Domain.js');

var app = angular.module('SecurityApp', ['toaster']);

module.exports = {"app": app, "security": security};

app.controller('MainCtrl', function ($scope, $http, toaster) {

});