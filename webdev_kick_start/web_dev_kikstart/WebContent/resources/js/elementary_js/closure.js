/**
 * 
 */

function datap() {
	function threeArguments(a, b, c) {
		return "We expect 3 arguments: " + a + ", " + b + ", " + c;
	}
	// Make a backup of the reference
	var threeArgumentsBackup = threeArguments;
	// Now we try to overload the function
	threeArguments = function(a, b, c, d) {
		return "Now we expect 4 arguments: " + a + ", " + b + ", " + c + ", "
				+ d;
	}
	// Now we attempt to use the first version
	document.write(threeArguments(1, 2, 3) + " <br /> "); // "We expect 4
	// arguments: 1,
	// 2, 3,
	// undefined"
	// Now we attempt to use the backuparguments: 1, 2, 3"
	// We see that the original reference to threeArguments has been
	// maintained.
}
function addToTen(num) {
	return function() {
		var ar = new Array();
		ar = [ 1, 2, 3, 4, 5 ];
		var p = 4;
		var q = 7;
		var z = p | q;
		console.log(z);
		console.log(num);
		var aa = 0;
		try {
			for (aa = 0; aa < 7; aa++) {
				console.log(ar[aa]);
			}
		} catch (err) {
			console.log(err.message);
		}
		return num + 10;
	}();
}

// A nice way to use closures with setTimeout
function putTextInLater(objID, text, timedelay) {
	setTimeout(function() {
		document.getElementById(objID).innerHTML = text;
	}, timedelay);
}

function multiplyFactory(multiplier) {
	return function(amount) {
		return amount * multiplier;
	}
}
/*
 * var timesTen = multiplyFactory(10); document.write(timesTen(4)); // 40
 */// putTextInLater('myDiv', 'Hello World!', 500);
/*var StringBuilder = (function() {
	var privateArray = new Array();
	function privateAppend(str) {
		privateArray[privateArray.length] = str;
	}
	return {
		add : function(str) {
			privateAppend(str);
		},
		value : function() {
			return privateArray.join("");
		}
	}
})();*/

function innerClosure() {
	var myArray = [ "Apple", "Car", "Tree", "Castle" ];
	var closureArray = new Array();
	// Loop through myArray and create a closure for each that outputs that item
	function writeItem(word) {
		return function() {
			document.write(word + "<br/>");
		}
	}

	for (var j = 0; j < myArray.length; j++) {
		var theItem = myArray[j];
		closureArray[j] = writeItem(theItem);
	}

	for (var i = 0; i < closureArray.length; i++) {
		closureArray[i]();
	}

}

function useApply() {

	var person = {
		name : "Daniel",
		age : 12,
		weight : "150lb",
		describe : function(useLongDesc) {
			document.write("Person’s name: " + this.name + " <br/> ");
			document.write("Person’s age: " + this.age + " <br/> ");
			if (useLongDesc == true) {
				document.write("Person’s weight: " + this.weight + " <br/> ");
			}
		}
	}

	var jamesBond = {
		name : "James, James bond.",
		age : "timeless",
		weight : "enough"
	}
	person.describe.apply(jamesBond, [ true ]);
}

function getGlobal() {
	return (function() {
		return this;
	}).call(null);
}

function invoker() {
	// putTextInLater('myDiv', 'Hello World!', 2000);
	// var timesTen = multiplyFactory(10);
	// document.write(timesTen(4)); // 40
	// First we show that the string is empty
	/*
	 * var array = new Array(); array[0] = "One"; array[1] = "Two"; array[2] =
	 * "Three"; document.write("Our String: " + array.join(" ") + " <br/> ");
	 */// "Our
	// document.write("Our String: " + StringBuilder.value() + " <br/> "); //
	// "Our
	// String:
	// "
	/*
	 * StringBuilder.add("Super"); StringBuilder.add("Cala");
	 * StringBuilder.add("Frajalistic"); // Now we display the finished
	 * concatenated string document.write("Our String: " + StringBuilder.value() + "
	 * <br/> ");
	 */// "Our
	// String:SuperCalaFrajalistic"
	// innerClosure();
	// useApply();
	// var myvar = getGlobal();
	// console
	// .log(myvar
	// .encodeURIComponent('http://myurl.com/index.php?myparam=true &
	// myparam2=hello'));
	// console.log(eval("1 + 1"));
	//
	// var elvis = {
	// name : "Elvis Presley",
	// occupation : "Rock Star",
	// status : "Abducted"
	// };
	//
	// with (elvis) {
	// eval("document.write(name);"); // "Elvis Presley"
	// }
	//	
	// var obj = new Object();
	// var p = obj.__defineGetter__();
	// console.log(p.toLocaleString());
	/*
	 * Object.prototype.toString = function() { var result = ""; for (prop in
	 * this) result += prop + ": " + this[prop].toString() + ", "; return
	 * result; } person = { name : "Elvis", age : 57 };
	 * document.write(person.toString());
	 */// name: Elvis, age: 57,
	/*
	 * person = { name : "Unknown", age : 0, height : "Unknown", weight :
	 * "Unknown", occupation : "Unknown", children : { count : 0, names : [] } }
	 * elvis = { name : "Elvis Presley", age : 57, occupation : "Rock Star" } //
	 * Now we merge person into elvis elvis.merge(person); // .. And test to see
	 * if one of the new properties were copied over document.write("Elvis’s
	 * Weight: " + elvis.weight); // "Unknown"
	 */
// var date = new Date();
// var ar = new Array(4);
//
// console.log(date.getType());
// console.log(ar.getType());
	
	// document.write("I am now in a styled DIV".tagify("div", "bigText"));
	// regexDemo();
	// arrayDemo();
	var a = {name:'francis',city:'delta',alpha:[{name:'egypt',vins:'gama'}]};
	var b = {name:'francis',city:'delta',alpha:[{name:'egypt',vins:'gama'}]};
	var q = a.isSame(b);
	alert(q);
}

/*Object.prototype.getType = function() {
	if (typeof (this) == "object") {
		if (this.constructor == Array)
			return "Array";
		if (this.constructor == Date)
			return "Date";
		if (this.constructor == RegExp)
			return "Regex";
	}
}*/

// Merges one object into another, preserving the original values if present
/*Object.prototype.merge = function(objSource) {
	// ensure that we are dealing with a valid object
	if (typeof this == "object" && objSource && typeof objSource == "object")
		for ( var arg in objSource)
			if (typeof objSource[arg] == "object" && !objSource[arg].length) {
				if (!this[arg])
					this[arg] = {};
				this[arg].merge(objSource[arg]);
			} else
				this[arg] = this[arg] || objSource[arg];
}

String.prototype.tagify = function(tag, cssClasses) {
	if (!cssClasses)
		cssClasses = ""; // Now ensure you passed a valid tag
	if (tag)
		return '<' + tag +" " + 'CLASS="' + cssClasses + '" > ' + this + ' </'
				+ tag + ' > ';
	else
		return this;
}*/

function regexDemo(){
	var regexpr = /\bturbo\B/gi;
	var s = "I am a turbo and turbocharged engine turbo";
	var q = regexpr.exec(s);
	// var q = s.indexOf(regexpr, 0);
	var results = s.match(regexpr);
	console.log(results);
	console.log(q);
	console.log(regexpr.lastIndex);
}

function arrayDemo(){
	var aray = new Array();
	var i=0;
	Array.observe(aray, function(changes) {
		console.log(++i+" here are "+changes);
		for(var p in changes){
			console.log(p);
		}
	});
	aray[0]="One";
	aray[1]=1;
	aray[2]=2;
	aray[3]="three";
	aray.pop();
	var ar2 = Array.from("foo",x => x + 2);
	console.log(ar2.reverse());
	aray.push("three");
	aray.push("three");
	aray.sort();
	aray.map(function(elt, i) {
		console.log(elt);
	});
	// console.log(aray.map);
	console.log(aray);
	console.log(aray.join(","));
	
	var arr = ['a', 'b', 'c'];
	var obj = arr.entries();
	console.log(obj.getType());
}

Object.prototype.isSame = function(cObj) {
	var result = true;
	if (cObj) {
	// Go one direction
		for (var key in cObj) {
				if (cObj[key]){
						if((typeof this[key])=="object" && (typeof cObj[key])=="object"){
							result = this[key].isSame(cObj[key]);
						}else if (!this[key] || (cObj[key] != this[key])) {
							result = false;
							break;
						}
				}
		}
		if (result == true) {
					// now go the other direction
			for (var key in this) {
				if (this[key]){
					if((typeof this[key])=="object" && (typeof cObj[key])=="object"){
						result = this[key].isSame(cObj[key]);
					}else if (!cObj[key] || (this[key] != cObj[key])) {
						result = false;
						break;
					}
				}
			}
		}	
	} 
	else 
		result = false;
	return result;
}

window.onload = invoker(); // datap();
