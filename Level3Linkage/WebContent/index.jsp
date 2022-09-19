<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="java.util.List"%><html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="js/jquery-1.4.2.min.js"></script>
<title>level3linkage</title>
</head>
<script type="text/javascript">

function getProvince() {
	$.ajax( {
		type :'post',
		url :'Province.action',
		dataType :'json',
		success : function(result) {
			$.each(result, function(entryIndex, entry) {
				var html = "<option value='" + entry.provinceID + "'>"
						+ entry.province + "</option>";
				$("#selprovince").append(html);
				;
			});
		}
	});
}

function getCity() {
	if (document.getElementById("citydiv").style.display == "block"
			|| document.getElementById("areadiv").style.display == "block") {
		document.getElementById("citydiv").style.display = "none";
		document.getElementById("areadiv").style.display = "none";
	}
	if (document.getElementById("citydiv").style.display == "none"
			&& document.getElementById("selprovince").value != 0) {
		document.getElementById("citydiv").style.display = "block";
	}
	$("#selcity option[value!=0]").remove();
	$("#selarea option[value!=0]").remove();
	var object = $("#selprovince");
	if (object.val() != 0) {
		$.ajax( {
			type :'post',
			url :'City.action',
			data : {
				id :object.val()
			},
			dataType :'json',
			success : function(result) {
				$.each(result, function(entryIndex, entry) {
					var html = "<option value='" + entry["cityID"] + "'>"
							+ entry["city"] + "</option>";
					$("#selcity").append(html);
				});
			}
		});
	}

}

function getArea() {
	if (document.getElementById("areadiv").style.display == "block") {
		document.getElementById("areadiv").style.display = "none";
	}
	if (document.getElementById("areadiv").style.display == "none"
			&& document.getElementById("selcity").value != 0) {
		document.getElementById("areadiv").style.display = "block";
	}
	$("#selarea option[value!=0]").remove();
	var object = $("#selcity");
	if (object.val() != 0) {
		$.ajax( {
			type :'post',
			url :'Area.action',
			data : {
				id :object.val()
			},
			dataType :'json',
			success : function(result) {
				$.each(result, function(entryIndex, entry) {
					var html = "<option value='" + entry["areaID"] + "'>"
							+ entry["area"] + "</option>";
					$("#selarea").append(html);
				});
			}
		});
	}
}
</script>
<body onload="getProvince()">
<table border="0">
	<tr>
		<td>
		<div style="display: block;">请选择住址： <select id="selprovince"
			style="width: 135px" onchange="getCity()">
			<option value="0">-请选择省份-</option>
		</select></div>
		</td>
		<td>
		<div id="citydiv" style="display: none;"><select id="selcity"
			style="width: 170px" onchange="getArea()">
			<option value="0">-请选择城市-</option>
		</select></div>
		</td>
		<td>
		<div id="areadiv" style="display: none;"><select id="selarea">
			<option value="0">-请选择地区-</option>
		</select></div>
		</td>
	</tr>
</table>
</body>
</html>