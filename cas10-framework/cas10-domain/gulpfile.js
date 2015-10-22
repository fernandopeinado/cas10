var gulp = require('gulp');
var gutil = require('gulp-util');
var gconcat = require('gulp-concat');
var gwatch = require('gulp-watch');
var guglify = require('gulp-uglify');
var gsourcemaps = require('gulp-sourcemaps');
var gbabel = require('gulp-babel');
var gbrowserify = require('gulp-browserify');
var babelify = require('babelify');
var shell = require('gulp-shell')

gulp.task('default', ['prepare-deps', 'js-compile']);

gulp.task('js-compile', function () {
    gulp.src('src/main/js/*/*App.js')
            .pipe(gbrowserify({
                insertGlobals: true,
                debug: true,
                transform: ['babelify']
            }))
            .on('error', function (error) {
                console.error('' + error);
            })
            .pipe(gulp.dest('target/classes/META-INF/resources/cas10'));
});

gulp.task('prepare-deps', function () {
    //angular
    gulp.src('./node_modules/angular/angular*.*', {base: './node_modules/angular'})
            .pipe(gulp.dest('./target/classes/META-INF/resources/cas10/lib/angular'));

    gulp.src('./node_modules/angular-route/angular*.*', {base: './node_modules/angular-route'})
            .pipe(gulp.dest('./target/classes/META-INF/resources/cas10/lib/angular'));
    
    //toaster
    gulp.src(['./node_modules/angularjs-toaster/toaster*.js', './node_modules/angularjs-toaster/toaster*.css'], 
            {base: './node_modules/angularjs-toaster'})
            .pipe(gulp.dest('./target/classes/META-INF/resources/cas10/lib/toaster'));
    
    //jquery
    gulp.src('./node_modules/jquery/dist/**', {base: './node_modules/jquery/dist'})
            .pipe(gulp.dest('./target/classes/META-INF/resources/cas10/lib/jquery'));
    
    //bootstrap
    gulp.src('./node_modules/bootstrap/dist/**', {base: './node_modules/bootstrap/dist'})
            .pipe(gulp.dest('./target/classes/META-INF/resources/cas10/lib/bootstrap'));
    
});

gulp.task('watch', function () {
    gulp.watch('src/main/js/**/*.js', function (event) {
        gutil.log('File ' + event.path + ' was ' + event.type + ', runngin tasks...');
        gulp.run('default');
    });
});
