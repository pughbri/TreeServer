//$('body').append('<div style="position: absolute; top: 37px; left: 360px; color: #ffffff;">Ship Control Input: <input style="background-color: #ffa8a8;" id="ship-controls"/></div>');

$('body').append('<div style="position: absolute; top: 37px; left: 560px; color: #ffffff;">session id: <input id="session-id"/></div>');
$('body').append('<div style="position: absolute; top: 37px; left: 800px; color: #ffffff;">starting person id: <input id="person-id"/></div>');
$('body').append('<div style="position: absolute; top: 34px; left: 1060px; color: #ffffff;"><button id="get-tree-data">Get Tree!</button></div>');

$('#get-tree-data').live('mouseup',storeSession);
//$('#person-id').live('keydown',storeSession);

function storeSession(e) {
  var session = $('#session-id')[0].value;
  var person = $('#person-id').get(0).value;
  $('body').append("<script src='http://ec2-50-16-100-28.compute-1.amazonaws.com:8080/treeserver/person/loadtree.js" + "?sessionid=" + session + "&personid=" + person + "'></script>");
//  alert('Do it!');
}

//javascript:(function(){self.opener.location='javascript:(function(){document.body.appendChild(document.createElement(\'script\')).src=\'http://ec2-50-16-101-127.compute-1.amazonaws.com/test2.js\';})()';self.close();})(
//javascript:(function(){self.opener.location='javascript:(function(){document.body.appendChild(document.createElement(\'script\')).src=\'http://ec2-50-16-100-28.compute-1.amazonaws.com:8080/treeserver/treeserver.js\';})()';self.close();})()
