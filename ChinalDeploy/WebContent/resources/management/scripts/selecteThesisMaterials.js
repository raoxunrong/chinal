
function select1All()
{
	for(var i=0;i<document.form[1].materialIds.length;i++)
	{
		document.form[1].materialIds[i].checked=select1.checked;
		
	}
	select2.checked=select1.checked;
}
function select2All()
{

	for(var i=0;i<document.form[1].materialIds.length;i++)
	{
		document.form[1].materialIds[i].checked=select2.checked;
		
	}
	select1.checked=select2.checked;
}
