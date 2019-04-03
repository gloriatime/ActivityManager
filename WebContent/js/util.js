dojo.require("dojo.widget.DateTimePicker");

function setStyle(id)
{
    document.getElementById(id).childNodes(1).style.width = "30.7em";
}
 
dojo.widget.defineWidget("struts:StrutsDatePicker", dojo.widget.HtmlWidget, 

	    {

	       //templateString: "<div class=\"caption\">${this.text}</div>",

	       //text: "",//default value

	       //templateCssPath: dojo.uri.dojoUri("WebContent/css/sign.css") 

	    }

	);
 
dojo.addOnLoad(function(){
        setStyle("begin");
        setStyle("end");
});