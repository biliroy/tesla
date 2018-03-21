$(document).ready(function() {
	validateRule();
});
$.validator.setDefaults({
	submitHandler : function(form) {
		save();
	}
});
function save() {
	$("#routeForm").ajaxSubmit({
		type : "POST",
		url : "/filter/route/save",
		dataType : 'json',
		error : function(request) {
			parent.layer.alert("Connection error");
		},
		success : function(data) {
			if (data.code == 0) {
				parent.layer.msg("操作成功");
				parent.reLoad();
				var index = parent.layer.getFrameIndex(window.name);
				parent.layer.close(index);

			} else {
				parent.layer.alert(data.msg)
			}

		}
	});
}
function validateRule() {
	var icon = "<i class='fa fa-times-circle'></i> ";
	$("#routeForm").validate({
		rules : {
			fromPath : {
				required : true
			},
			serviceName : {
				required : {
					depends : function(value, element) {
						var isRpc = $('#rpc').val();
						return isRpc == 1;
					}
				}
			},
			methodName : {
				required : {
					depends : function(value, element) {
						var isRpc = $('#rpc').val();
						return isRpc == 1;
					}
				}
			},
			serviceGroup : {
				required : {
					depends : function(value, element) {
						var isRpc = $('#rpc').val();
						return isRpc == 1;
					}
				}
			},
			serviceVersion : {
				required : {
					depends : function(value, element) {
						var isRpc = $('#rpc').val();
						return isRpc == 1;
					}
				}
			},
			zipFile : {
				required : {
					depends : function(value, element) {
						var isRpc = $('#rpc').val();
						return isRpc == 1;
					}
				}
			},
			serviceFileName : {
				required : {
					depends : function(value, element) {
						var isRpc = $('#rpc').val();
						if (isRpc == 1) {
							return $('#zipFile').val() != null;
						} else {
							return false;
						}
					}
				}
			}
		},
		messages : {
			fromPath : {
				required : icon + "请输入路由路径！"
			},
			serviceName : {
				required : "请输入服务名！"
			},
			methodName : {
				required : "请输入方法名！"
			},
			serviceGroup : {
				required : "请输入组别！"
			},
			serviceVersion : {
				required : "请输入版本！"
			},
			zipFile : {
				required : "请上传proto目录文件！"
			},
			serviceFileName : {
				required : "上传proto目录文件，需要指定目录中的服务定义文件名！"
			}
		}
	})
}