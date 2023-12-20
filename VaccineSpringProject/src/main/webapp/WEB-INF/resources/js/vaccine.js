function validate()
{
    var un=document.getElementById("username").value 
    var unp=/^[a-zA-Z]+$/
    var ph=document.getElementById("mobileNo").value 
    var php=/^[6-9]{1}[0-9]{9}$/
    var pwd=document.getElementById("pwd").value
    var cpwd=document.getElementById("cpwd").value
    if(un=="")
    {
        document.getElementById("msg").innerHTML="Enter the Username"
        return false
    }
    if(!un.match(unp))
    {
        document.getElementById("msg").innerHTML="UserName Contains Alphabets Only"
        return false
    }
    if(un.length<3)
    {
        document.getElementById("msg").innerHTML="Minimum 3 Characters"
        return false
    }
    if(un.length>8)
    {
        document.getElementById("msg").innerHTML="Maximum 8 characters only"
        return false
    }
    if(ph=="")
    {
        document.getElementById("msg1").innerHTML="Enter the Phone Number"
        return false
    }
    if(!ph.match(php))
    {
        document.getElementById("msg1").innerHTML="Invalid Phone Number"
        return false
    }
    if(pwd=="")
    {
		document.getElementById("msgp").innerHTML="Enter the Password"
        return false
	}
	if(pwd!=cpwd)
	{
		document.getElementById("msgp").innerHTML="match the password"
        return false
	}
}