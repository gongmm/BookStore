//商品数量的增加
function number(){
    var Input0=document.getElementById('input0');
    var Input1=document.getElementById('input1');
    var Input2=document.getElementById('input2');

    Input1.onclick=function(){
        this.form.amount.value++;
    }

    Input2.onclick=function(){
        if(Input0.value>1){
            this.form.amount.value--;
        }
    }
}

window.onload = function () {
    number();
};
