function post(URL, PARAMS) {        
        var temp = document.createElement("form");        
        temp.action = URL;        
        temp.method = "post";        
        temp.style.display = "none";        
        for (var x in PARAMS) {        
            var opt = document.createElement("textarea");        
            opt.name = x;        
            opt.value = PARAMS[x];           
            temp.appendChild(opt);        
        }        
        document.body.appendChild(temp);        
        temp.submit();             
    } 
function post2(URL, PARAMS, target) {        
    var temp = document.createElement("form");        
    temp.action = URL;        
    temp.method = "post";       
    temp.target =  target;   
    temp.style.display = "none";        
    for (var x in PARAMS) {        
        var opt = document.createElement("textarea");        
        opt.name = x;        
        opt.value = PARAMS[x];           
        temp.appendChild(opt);        
    }        
    document.body.appendChild(temp);        
    temp.submit();             
} 
function ajaxPost(URL,PARAMS){
	$.ajax({
        type: "post",
        url: URL,
        dataType: "json",
        data: PARAMS,
        success: function(json) {
        	alert(JSON.stringify(json));
        }
 	});
}