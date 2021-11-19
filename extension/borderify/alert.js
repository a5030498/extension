/*
,{
	"run_at": "document_idle",
	  "matches": [
		"<all_urls>"
	  ],
	  "js": ["alert.js"]
	}

*/
console.log("console console");
console.log("console console");
console.log("測試");
console.log("測試");
function getAlert() {
	window.alert = function alert(msg) {
		console.log(msg);
		let data = {
			event: 'Alert',
			className: "",
			id: "",
			name: "",
			value: msg,
			tagName: "",
			xpath: "",
			cssSelector: "",
			fullXpath: ""
		}
		var JsonData = JSON.stringify(data);
		fetch('http:/localhost:8080/event/storeEvent', {
			method: 'POST',
			headers: {
				'Content-Type': 'application/json'
			},
			body: JsonData
		})
			.then(res => {
				return console.log(res.status);
			})
		return oldAlert(msg);
	};
};
function getConfirm() {
	window.confirm = function confirm(msg) {
		console.log(msg);
		let data = {
			event: 'Confirm',
			className: "",
			id: "",
			name: "",
			value: msg,
			tagName: "",
			xpath: "",
			cssSelector: "",
			fullXpath: ""
		}
		var JsonData = JSON.stringify(data);
		fetch('http:/localhost:8080/event/storeEvent', {
			method: 'POST',
			headers: {
				'Content-Type': 'application/json'
			},
			body: JsonData
		})
			.then(res => {
				return console.log(res.status);
			})
		return oldConfirm(msg);
	};
};
function getPrompt() {
	window.prompt = function prompt(msg) {
		console.log(msg);
		let data = {
			event: 'Prompt',
			className: "",
			id: "",
			name: "",
			value: msg,
			tagName: "",
			xpath: "",
			cssSelector: "",
			fullXpath: ""
		}
		var JsonData = JSON.stringify(data);
		fetch('http:/localhost:8080/event/storeEvent', {
			method: 'POST',
			headers: {
				'Content-Type': 'application/json'
			},
			body: JsonData
		})
			.then(res => {
				return console.log(res.status);
			})
		return oldPrompt(msg);
	};
};




var script = document.createElement('script');
script.appendChild(document.createTextNode('  const oldAlert = window.alert; const oldConfirm = window.confirm; const oldPrompt = window.prompt;    (' + getAlert + ')();(' + getPrompt + ')();(' + getConfirm + ')();'));
document.documentElement.appendChild(script);

