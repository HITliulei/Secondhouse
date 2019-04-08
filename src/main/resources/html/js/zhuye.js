/**
 * Created by lijiaxingon 2018/8/1.
 */
function login() {
    document.getElementById("hiddenthing1").style.display = "block";
}

function adminlogin() {
    document.getElementById("hiddenthing2").style.display = "block";
}

function sellerlogin() {
    document.getElementById("hiddenthing3").style.display = "block";
}

function hideModel1() {
    document.getElementById("hiddenthing1").style.display = "none";
}

function hideModel2() {
    document.getElementById("hiddenthing2").style.display = "none";
}

function hideModel3() {
    document.getElementById("hiddenthing3").style.display = "none";
}

function change(obj){
			obj.src="/ruidaoshangcheng/checkimg?time="+new Date().getTime();
	        }