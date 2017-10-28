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
        backbone: '../yarn_components/backbone/backbone',
        bootstrap: '../yarn_components/bootstrap/dist/js/bootstrap',
        i18n: '../yarn_components/requirejs-i18njs/dist/requirejs-i18njs.min',
        jquery: '../yarn_components/jquery/dist/jquery.min',
        moment: '../yarn_components/moment/moment',
        text: '../yarn_components/requirejs-text/text',
        underscore: '../yarn_components/underscore/underscore'
    },
    shim: {
        backbone: {
            exports: 'Backbone'
        },
        bootstrap: ['jquery','moment-adapter','chartjs'],
        'moment-adapter':{
            exports:'moment'
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
