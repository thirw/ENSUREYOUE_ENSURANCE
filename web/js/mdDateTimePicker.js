angular.module('MyApp',['ngMaterial', 'ngMessages', 'material.svgAssetsCache']).controller('AppCtrl', function() {
  this.myDate = new Date();

  this.minDate = new Date(
    this.myDate.getFullYear(),
    this.myDate.getMonth() - 2,
    this.myDate.getDate()
  );

  this.maxDate = new Date(
    this.myDate.getFullYear(),
    this.myDate.getMonth() + 2,
    this.myDate.getDate()
  );

  this.onlyWeekendsPredicate = function(date) {
    var day = date.getDay();
    return day === 0 || day === 6;
  };
});


/**
Copyright 2016 Google Inc. All Rights Reserved. 
Use of this source code is governed by an MIT-style license that can be foundin the LICENSE file at http://material.angularjs.org/HEAD/license.
**/