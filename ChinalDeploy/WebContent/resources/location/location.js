function getCities(provinceId) {
	if (provinceId == "") {
		$("#provinceId").options.length = 0;
		return;
	} else {
		$
				.ajax({
					type : "GET",
					url : '/ChinalDeploy/management/location/getCitiesByProvince?provinceId='
							+ provinceId,
					dataType : "json",
					success : function(json) {
						var optionString = '';
						var cityList = JSON.stringify(json);
						cityList = eval('(' + cityList + ')');
						for ( var index in cityList) {
							optionString += '<option value="'
									+ cityList[index].id + '">'
									+ cityList[index].name + '</option>';
						}
						$("#cityId").html(optionString);
					},
					error : function(xhr) {
						alert('无法获取城市信息');
					}
				});
	}
}