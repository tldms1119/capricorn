function formatSize(bytes, dm=0){	
	if(bytes == 0) return '0B';
	var k = 1000,
		i = Math.floor(Math.log10(bytes) / Math.log10(k));
	
	return parseFloat((bytes / Math.pow(k, i)).toFixed(dm)) + sizes[i];
};

function random(range, start=0){
	return Math.floor(Math.random() * range) + start;
};

function compareIgnoreCase (left, right) {
	var left2 = left.toLowerCase();
	var right2 = right.toLowerCase();
	if(left2 < right2) return -1;
	if(left2 > right2) return 1;
	return 0;
};

Array.prototype.shuffle = function(){
	var arr = this.slice(0);				// shuffle 호출한 배열 객체 = this
	
	for(var i = arr.length-1; i > 0; i--){
		var rx = random(i + 1);
		var temp = arr[i];
		arr[i] = arr[rx];
		arr[rx] = temp;
	}
	
	return arr;
};

Array.prototype.range = function(start, end) {
	for(var i = start; i <= end; i++){
		this.push(i);
	}
	return this;
};

Date.prototype.dateFormat = function(){
	var year = this.getFullYear();
	var month = this.getMonth() + 1;
	var date = this.getDate();

	month = (month < 10) ? '0' + month : month;
	date = (date < 10) ? '0' + date : date;

	return `${year}-${month}-${date}`;
};

Date.prototype.timeFormat = function(){
	var hour = this.getHours();
	var minute = this.getMinutes();
	var second = this.getSeconds();
	
	hour = (hour < 10) ? '0' + hour : hour;
	minute = (minute < 10) ? '0' + minute : minute;
	second = (second < 10) ? '0' + second : second;

	return `${hour}:${minute}:${second}`;
};

$.scroll = function(fn) {
	$(window).scroll(function(){
		var scrollHeight = $(window).scrollTop() + $(window).height();
		var documentHeight = $(document).height();
		if(scrollHeight > documentHeight-100){
			if(fn){
				fn();
			} 
		}
	});
}

/*$(document).ready(function(){		
	$('.jumbotron').load("common/header.html");		
	$('nav').load('common/menu.html');
	$('footer').load('common/footer.html');
});*/

var images = [
	"img/bird_strike.JPG",
	"img/bird.JPG",
	"img/Desert.jpg",
	"img/picture.jpg",
	"img/Jellyfish.jpg",
	"img/Lighthouse.jpg",
	"img/Koala.jpg"
];