/**
 * 
 */

function mySpecialFunction2() {
	/*
	 * Element div = document.getElementById("data_div");
	 */
	var babyNames = [ "Micheal", "Ryan", "Matea", "Mitchell", "Farris", "Cia",
			"Larry" ];
	document.write("length" in babyNames);
	document.write("<br/>");
	document.write("Ryan" in babyNames);
	document.write("<br/>");
	var myObject = {
		apple : true,
		funny : false
	};
	document.write("apple" in myObject); // true
	document.write("<br/>");
	document.write("funny" in myObject); // true

	var Animal = function(thename) {
		this.fur = true;
		this.scales = false;
		this.name = 'Generic';
		if (thename) {
			this.name = thename;
		}
	};

	var newAnimal = new Animal('cat');
	document.write("<br/>");
	document.write(newAnimal.name);
	document.write(newAnimal.toLocaleString());
	document.write("<br/>");
	var writeln = function(message) {
		if (message) {
			document.writeln(message);
		}
	}
	writeln('hey i am new function');
	document.writeln("<br/>")
	function elemfunction() {
		for (var i = 0; i < arguments.length; i++) {
			document.write(i + " = " + arguments[i] + " <br/>");
		}
	}

	elemfunction("hello", 22, new Date());
}

function mySpecialFunction() {
	function addsquare(a, b) {
		function multiply(x, y) {
			return x * y;
		}
		return multiply((a + b), (a + b));
	}

	document.writeln(addsquare(2, 3));

	/* closures example */
	function greetMe(name) {
		return function(greeting) {
			return greeting + "  " + name;
		}
	}

	var greetAlex = greetMe('Alex');
	document.writeln(greetAlex('hello'));
}

function delaysWithoutClosure() {
	function putTextInLater(objID, text, timedelay) {
		setTimeout("document.getElementById('" + objID + "').innerHTML = '"
				+ text + "'", timedelay);
	}
	putTextInLater('data_div', 'Hello World!', 2000);
}

function delayWithClosure() {
	function putTextInLater(objID, text, timedelay) {
		setTimeout(function() {
			document.getElementById(objID).innerHTML = text;
		}, timedelay);
	}
	putTextInLater('data_div', 'Hello World!', 2000);
}

function stringBuilderDemo() {

	var StringBuilder = (function() {
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
	})();

	document.write("Our String: " + StringBuilder.value() + " <br/> "); // "Our
	// String:
	// "
	StringBuilder.add("Super");
	StringBuilder.add("Cala");
	StringBuilder.add("Frajalistic");
	// Now we display the finished concatenated string
	document.write("Our String: " + StringBuilder.value() + " <br/> "); // "Our
	// String:SuperCalaFrajalistic"
}

function closureArrayDemo() {

	// A correct use of closures within loops
	var myArray = [ "Apple", "Car", "Tree", "Castle" ];
	var closureArray = new Array();

	function writeItem(word) {
		return function() {
			document.write(word + "<br/>");
		}
	}

	for (var m = 0; m < myArray.length; m++) {
		var theItem = myArray[m];
		closureArray[m] = writeItem(theItem);
	}

	for (var i = 0; i < closureArray.length; i++) {
		closureArray[i]();
	}
}