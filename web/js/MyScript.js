function show() {
    var x = document.getElementById('first').value;
    if (x == 1) {
        $("#second").empty();
        $("#second").append("<option style='display: none;'></option>", "<option>เป็นเงินทุนการศึกษาลูก</option>", "<option>สวัสดิการสุขภาพ</option>", "<option>เพื่อลดหย่อนภาษี</option>");
    } else if (x == 2) {
        $("#second").empty();
        $("#second").append("<option style='display: none;'></option>", "<option>เป็นเงินทุนการศึกษาลูก</option>", "<option>สวัสดิการสุขภาพ</option>", "<option>เพื่อลดหย่อนภาษี</option>");
    } else if (x == 3) {
        $("#second").empty();
        $("#second").append("<option style='display: none;'></option>", "<option>สวัสดิการสุขภาพ</option>", "<option>เพื่อลดหย่อนภาษี</option>");
    } else if (x == 4) {
        $("#second").empty();
        $("#second").append("<option selected>สวัสดิการสุขภาพ</option>");
    } else if (x == 5) {
        $("#second").empty();
        $("#second").append("<option style='display: none;'></option>", "<option>คุ้มครองการเสียชีวิต</option>", "<option>เก็บออม มีเงินก้อนไว้ใช้</option>", "<option>เพื่อมีเงินใช้หลังเกษียณ</option>");
    } else if (x == 6) {
        $("#second").empty();
        $("#second").append("<option style='display: none;'></option>", "<option>คุ้มครองการเสียชีวิต</option>", "<option>เก็บออม มีเงินก้อนไว้ใช้</option>", "<option>เพื่อมีเงินใช้หลังเกษียณ</option>");
    }
}
$(document).ready(function(){
    $("#xxx").click(function(){
        $("#xx").toggle();
    });
});