/**
 * Created by Administrator on 2017/7/22.
 */
var code;
createCode();
function createCode() {
    code = "";
    var codeLength = 4;//验证码的长度
    var checkCode = document.getElementById("check_Code");
    var selectChar = new Array( 1, 2, 3, 4, 5, 6, 7, 8, 9,'A','B','C','D','E','F','G','H','I','J','K','L','M','N','P','Q','R','S','T','U','V','W','X','Y','Z');//所有候选组成验证码的字符，当然也可以用中文的

    for (var i = 0; i < codeLength; i++) {
        var charIndex = Math.floor(Math.random() * 34);
        code += selectChar[charIndex];
    }
    if (checkCode) {
        checkCode.className = "code";
        checkCode.innerHTML = code;
    }
}

//通知公告结束

