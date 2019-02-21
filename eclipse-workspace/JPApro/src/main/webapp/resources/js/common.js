



function getReplyList(bno){
	
	$.getJSON("/replies/all/"+bno, function(data){
		var str="";
		
		$(data).each(
				function(){
					str +="<li class='list-group-item note-item clearfix' id='note-1'>" 
						+ "<div class='content-body panel-body pull-left' style='width:1500px'>" 
						+ "<div class='avatar-info'><a class='nickname' href='#' title='"+this.replyWriter+"'>"
						+ this.replyWriter + "</a></div>" 
						+ "<div class='date-created'><span class='timeago' title='"+this.timestamp+"'>"+this.timestamp
						+ "</span>" 
						+ "</div>"
						+ "<fieldset class='form'><article id='note-text-1' class='list-group-item-text note-text'>" 
						+ "<p id='replyArea-"+this.rno+"' text='"+this.reply+"'>"+this.reply+"</p><p><br></p></article></fieldset></div></div>"
						+ "<div class='content-function pull-right text-center'>"
						+ "<button id='delete-'"+this.rno+" onclick='deleteReply("+this.rno+")'>delete</button>"
						+ "<button id='update-'"+this.rno+" onclick='updateReply("+this.rno+")'>update</button>";
				});
		$("#replyTemplateArea").html(str);
	});
}

function updateReply(rno){
	
//	ulObj.removeChild(liObjs[1]);
	var exReply = $("#replyArea-"+rno).text();
	
	var str="<input type='text' id='updateReply' value='"+exReply+"'></input>";
	var str2= "<button id='update' onclick='updateReplyDO("+rno+")'>update</button>";
	
	str= str+str2;
	$("#replyArea-"+rno).empty();
	$("#replyArea-"+rno).html(str);
}

function updateReplyDO(rno){
	
	let bno = parseInt($("#bno").val());
	let reply = $("#updateReply").val();
	
	$.ajax({
		url : "/replies/"+rno,
		type : "PUT",
		headers : {
			"Content-Type" : "application/json"
		},
		dataType: "text",
		data : JSON.stringify({
			rno: rno,
			reply:reply
		}),
		// dataType: 'json',
		success : function(res) {
			if (res == 'SUCCESS') {
				alert("updated");
				getReplyList(bno);
			} else {
				alert("error");
			}
		}
	});
}

function deleteReply(rno){
	
	let bno = $("#bno").val();
	
	$.ajax({
		url : "/replies/"+rno,
		type : "delete",
		headers : {
			"Content-Type" : "application/json"
		},
		dataType: "text",
		data : JSON.stringify({
			rno: rno
		}),
		// dataType: 'json',
		success : function(res) {
			if (res == 'SUCCESS') {
				alert("deleted");
				getReplyList(bno);
			} else {
				alert("error");
			}
		}
	});
}

function createReplyAjax(){
	
	let reply = $("#reply").val();
	let replyWriter = $("#replyWriter").val();
	let bno = $("#bno").val();
	
	$.ajax({
		url : "/replies",
		type : "post",
		headers : {
			"Content-Type" : "application/json"
//			"X-HTTP-Method-Override" : "POST"
		},
		dataType: "text",
		data : JSON.stringify({
			bno: bno,
			replyWriter :replyWriter,
			reply : reply
		}),
		// dataType: 'json',
		success : function(res) {
			if (res == 'SUCCESS') {
				alert("registered");
				getReplyList(bno);
			} else {
				alert("error");
			}
		}
	});
}

// jpg,gif,png,jpeg 확장자 찾는 함수
function checkImageType(data) {

	var pattern = /jpg|gif|png|jpeg/i;

	return fileName.match(pattern);
}

function deleteItem(formId) {

	var form = document.createElement('form');
	form.setAttribute("method", "Post"); // Get 또는 Post 입력
	form.setAttribute("action", "deleteItem");
	var hiddenField = document.createElement("input");
	hiddenField.setAttribute("type", "hidden");
	hiddenField.setAttribute("name", "bno");
	var bno = $("#bno").val();
	hiddenField.setAttribute("value", bno);
	form.appendChild(hiddenField);
	document.body.appendChild(form);
	form.submit();
}

jQuery.fn.serializeObject = function() {
	var obj = null;
	try {
		if (this[0].tagName && this[0].tagName.toUpperCase() == "FORM") {
			var arr = this.serializeArray();
			if (arr) {
				obj = {};
				jQuery.each(arr, function() {
					obj[this.name] = this.value;
				});
			}
		}
	} catch (e) {
		alert(e.message);
	} finally {
	}
	return obj;
}

