/*
 * Copyright 2014-2015 Hewlett-Packard Development Company, L.P.
 * Licensed under the MIT License (the "License"); you may not use this file except in compliance with the License.
 */
var localeName = localStorage.getItem('find-locale') || 'ru-ru';
var logArray = new Array('0');
var inConfig = new Array('0');
require.config({
    paths: {
        css: '../css',
        backbone: '../bower_components/backbone/backbone',
        bootstrap: '../bower_components/bootstrap/dist/js/bootstrap',
        d3: '../bower_components/d3/d3',
        i18n: '../bower_components/requirejs-i18n/i18n',
        jquery: '../bower_components/jquery/jquery',
        json2: '../bower_components/json/json2',
        'login-page': '../bower_components/hp-autonomy-login-page/src',
        leaflet: '../bower_components/leaflet/dist/leaflet-src',
        moment: '../bower_components/moment/moment',
        text: '../bower_components/requirejs-text/text',
        underscore: '../bower_components/underscore/underscore',
    },
    shim: {
        backbone: {
            exports: 'Backbone'
        },
        bootstrap: ['jquery','moment-adapter','chartjs'],
        'moment-adapter':{
            exports:'moment'
        },
        d3: {
            exports: 'd3'
        },
        underscore: {
            exports: '_'
        }
    },
    config: {
        //Set the config for the i18n
        //module ID
        i18n: {
            locale: localeName
        }
    }
});
