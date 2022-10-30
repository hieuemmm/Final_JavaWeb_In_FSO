document.getElementById("Report").onchange = function loadReport() {
	document.getElementById("myChart").classList.replace('d-block', 'd-none');
	document.getElementById('contentTop').style.height = '600px';
	document.getElementById("selectYear").classList
			.replace('d-block', 'd-none');
	document.getElementById("bocChart").classList.replace('d-block', 'd-none');
	document.getElementById('nextInjectionDate').style.display = ' block';
	document.getElementById('origin').style.display = ' block';
	document.getElementById('vaccineType').style.display = ' block';
	document.getElementById('action').style.display = ' block';
	document.getElementById('myReport').style.display = ' block';
	document.getElementById('phanTrang').style.display = 'block';

}

document.getElementById("selectYearSL").onchange = function loadYear() {
	var yearChoosed = document.getElementById("selectYearSL").children;
	var monthData;
	var numberData;
	for (var i = 0; i < yearChoosed.length; i++) {
		if (yearChoosed[i].selected) {
			if (i == 0) {
				monthData = document.getElementsByClassName("month1");
				numberData = document.getElementsByClassName("number1");
			} else if (i == 1) {
				monthData = document.getElementsByClassName("month2");
				numberData = document.getElementsByClassName("number2");
			} else if (i == 2) {
				monthData = document.getElementsByClassName("month3");
				numberData = document.getElementsByClassName("number3");
			} else if (i == 3) {
				monthData = document.getElementsByClassName("month4");
				numberData = document.getElementsByClassName("number4");
			} 
		}
	}
	let massPopChart = new Chart(myChart, {
		type : 'bar', // bar, horizontalBar, pie, line, doughnut, radar, polarArea
		data : {
			labels : [ 'January', 'February', 'March', 'April', 'May',
					'June', 'July', 'August', 'September', 'October',
					'November', 'December' ],
			datasets : [ {
				label : 'Population',
				data : [ numberData[0].innerHTML,
						numberData[1].innerHTML,
						numberData[2].innerHTML,
						numberData[3].innerHTML,
						numberData[4].innerHTML,
						numberData[5].innerHTML,
						numberData[6].innerHTML,
						numberData[7].innerHTML,
						numberData[8].innerHTML,
						numberData[9].innerHTML,
						numberData[10].innerHTML,
						numberData[11].innerHTML ],

				backgroundColor : [ '#80DEEA', '#80DEEA', '#80DEEA',
						'#80DEEA', '#80DEEA', '#80DEEA', '#80DEEA',
						'#80DEEA', '#80DEEA', '#80DEEA', '#80DEEA',
						'#80DEEA'

				],
				borderWidth : 0,
				borderColor : '#777',
				hoverBorderWidth : 3,
				hoverBorderColor : '#000'
			} ]
		},
		options : {
			legend : {
				display : false,
				position : 'right',
				labels : {
					fontColor : '#000'
				}
			},
			layout : {
				padding : {
					left : 50,
					right : 0,
					bottom : 0,
					top : 0
				}
			},
			tooltips : {
				enabled : true
			}
		}
	});
}
document.getElementById("Chart").onchange = function loadChart() {
	document.getElementById('myReport').style.display = 'none';
	document.getElementById('phanTrang').style.display = 'none';
	document.getElementById('contentTop').classList.remove('h-100');
	document.getElementById('contentTop').style.height = '111px';
	document.getElementById('origin').style.display = ' none';
	document.getElementById('vaccineType').style.display = ' none';
	document.getElementById('action').style.display = ' none';
	document.getElementById("nextInjectionDate").style.display = 'none';
	document.getElementById("selectYear").classList
			.replace('d-none', 'd-block');
	document.getElementById("bocChart").classList.replace('d-none', 'd-block');
	document.getElementById("myChart").classList.replace('d-none', 'd-block');

	var monthData = document.getElementsByClassName("month1");
	var numberData = document.getElementsByClassName("number1");

	let myChart = document.getElementById('myChart').getContext('2d');
	// Global Options
	Chart.defaults.global.defaultFontFamily = 'Lato';
	Chart.defaults.global.defaultFontSize = 10;
	Chart.defaults.global.defaultFontColor = '#777';

	let massPopChart = new Chart(myChart, {
		type : 'bar', // bar, horizontalBar, pie, line, doughnut, radar,
						// polarArea
		data : {
			labels : [ 'January', 'February', 'March', 'April', 'May', 'June',
					'July', 'August', 'September', 'October', 'November',
					'December' ],
			datasets : [ {
				label : 'Population',
				data : [ numberData[0].innerHTML, numberData[1].innerHTML,
						numberData[2].innerHTML, numberData[3].innerHTML,
						numberData[4].innerHTML, numberData[5].innerHTML,
						numberData[6].innerHTML, numberData[7].innerHTML,
						numberData[8].innerHTML, numberData[9].innerHTML,
						numberData[10].innerHTML, numberData[11].innerHTML ],
				// backgroundColor:'green',
				backgroundColor : [  '#80DEEA', '#80DEEA', '#80DEEA',
					'#80DEEA', '#80DEEA', '#80DEEA', '#80DEEA',
					'#80DEEA', '#80DEEA', '#80DEEA', '#80DEEA',
					'#80DEEA'

				],
				borderWidth : 0,
				borderColor : '#777',
				hoverBorderWidth : 3,
				hoverBorderColor : '#000'
			} ]
		},
		options : {
			/*
			 * title:{ display:true, text:'REPORT VACCINE CHART', fontSize: 20,
			 *  },
			 */
			legend : {
				display : false,
				position : 'right',
				labels : {
					fontColor : '#000'
				}
			},
			layout : {
				padding : {
					left : 50,
					right : 0,
					bottom : 0,
					top : 0
				}
			},
			tooltips : {
				enabled : true
			}
		}
	});
}