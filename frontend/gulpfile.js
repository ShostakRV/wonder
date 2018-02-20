'use strict';

var gulp = require('gulp');
var multiDest = require('gulp-multi-dest');

var paths = {
    dirInput: 'build/**/*',
    dirOutput: ['../backend/out/production/resources/static'],
    IndexInput: 'build/*.html',
    IndexOutput: [
        '../backend/out/production/resources/templates/',
    ]
};

var destOptions = {
    mode: 755
};

gulp.task('sync_devResources', function () {
    gulp.src(paths.dirInput)
        .pipe(multiDest(paths.dirOutput));
    gulp.src(paths.IndexInput)
        .pipe(multiDest(paths.IndexOutput));
});
gulp.task('default', ['sync_devResources']);
gulp.task('build', ['sync_devResources']);
