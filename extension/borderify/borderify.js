document.addEventListener("click", clickEvent);
document.addEventListener("change", changeEvent);
document.addEventListener("contextmenu", contextmenuEvent);
document.addEventListener("submit", submitEvent);
window.addEventListener("onblur", clickEvent);
console.log("test console");
console.log("test console");



function changeEvent(e) {
	let { className, id, value, name, text, tagName, cssSelector, type } = e.target;
	var xpath = Xpath.getElementXPath(e.target);
	var fullXpath = Xpath.getFullElementXPath(e.target);

	cssSelector = "";
	let data = {
		event: 'sendKeys',
		className: className,
		id: id,
		name: name,
		value: value,
		tagName: tagName,
		xpath: xpath,
		cssSelector: cssSelector,
		fullXpath: fullXpath
	}
	fetchToEvent(data);
};
function keydownEvent(e) {
	console.log(e.code);
};
function submitEvent(e) {
	let { className, id, value, name, text, tagName, cssSelector, type } = e.target;
	var xpath = Xpath.getElementXPath(e.target);
	var fullXpath = Xpath.getFullElementXPath(e.target);

	cssSelector = "";
	let data = {
		event: 'submit',
		className: className,
		id: id,
		name: name,
		value: value,
		tagName: tagName,
		xpath: xpath,
		cssSelector: cssSelector,
		fullXpath: fullXpath
	}
	fetchToEvent(data);
};
function contextmenuEvent(e) {
	console.log(e);
};
function resizeEvent(e) {
	console.log(e);
}
function clickEvent(e) {

	let { className, id, value, name, innerText, tagName, cssSelector, type } = e.target;
	var xpath = Xpath.getElementXPath(e.target);
	var fullXpath = Xpath.getFullElementXPath(e.target);
	if (name == null) { name = ""; }

	if (type != 'submit') {
		if (!(e.target.href)) {
			var url = "";
		} else {
			var url = e.target.href;
			var currentUrl = window.location.href;

		}
		cssSelector = "";

		var data = {
			event: 'click',
			className: className,
			id: id,
			name: name,
			text: innerText,
			url: url,
			currentUrl: currentUrl,
			tagName: tagName,
			xpath: xpath,
			cssSelector: cssSelector,
			fullXpath: fullXpath
		};
		console.log(JSON.stringify(data));
		fetchToEvent(data);
	}
};

function fetchToEvent(data) {
	var JsonData = JSON.stringify(data);
	fetch('http:/localhost:8080/event/storeEvent', {
		method: 'POST',
		headers: {
			'Content-Type': 'application/json'
		},
		body: JsonData
	})
		.then(res => {
			return console.log("hiiii"+res.status);
		})
};
var Xpath = {};
Xpath.getElementXPath = function (element) {
	if (element && element.id)
		return '//*[@id="' + element.id + '"]';
	else
		return Xpath.getElementTreeXPath(element);
};

Xpath.getFullElementXPath = function (element) {
	return Xpath.getElementTreeXPath(element);
};


Xpath.getElementTreeXPath = function (element) {
	var paths = [];  // Use nodeName (instead of localName) 
	// so namespace prefix is included (if any).
	for (; element && element.nodeType == Node.ELEMENT_NODE;
		element = element.parentNode) {
		var index = 0;
		var hasFollowingSiblings = false;
		for (var sibling = element.previousSibling; sibling;
			sibling = sibling.previousSibling) {
			// Ignore document type declaration.
			if (sibling.nodeType == Node.DOCUMENT_TYPE_NODE)
				continue;

			if (sibling.nodeName == element.nodeName)
				++index;
		}

		for (var sibling = element.nextSibling;
			sibling && !hasFollowingSiblings;
			sibling = sibling.nextSibling) {
			if (sibling.nodeName == element.nodeName)
				hasFollowingSiblings = true;
		}

		var tagName = (element.prefix ? element.prefix + ":" : "")
			+ element.localName;
		var pathIndex = (index || hasFollowingSiblings ? "["
			+ (index + 1) + "]" : "");
		paths.splice(0, 0, tagName + pathIndex);
	}

	return paths.length ? "/" + paths.join("/") : null;
};


