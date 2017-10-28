var gulp = require('gulp');
var pug = require('gulp-pug');
// var less = require('gulp-less');
// var minifyCSS = require('gulp-csso');

gulp.task('html', function () {
    return gulp.src('client/templates/*.pug')
        .pipe(pug())
        .pipe(gulp.dest('build/html'))
});

gulp.task('css', function () {
    return gulp.src('client/templates/*.less')
        .pipe(less())
        .pipe(minifyCSS())
        .pipe(gulp.dest('build/css'))
});

var watch = require('gulp-watch');

var source = 'src/main/public/static',
    destination = 'out/production/resources/static';

gulp.task('watch-folder', function () {
    gulp.src(source + '/**/*', {base: source,verbose:true})
        .pipe(watch(source, {base: source,verbose:true}))
        .pipe(gulp.dest(destination));
});

var source2 = 'src/main/resources/',
    destination2 = 'out/production/resources/';

gulp.task('watch-folder2', function () {
    gulp.src(source2 + '/**/*', {base: source2,verbose:true})
        .pipe(watch(source2, {base: source2,verbose:true}))
        .pipe(gulp.dest(destination2));
});

gulp.task('default', ['watch-folder','watch-folder2']);
// gulp.task('default', [ 'html', 'css' ]);