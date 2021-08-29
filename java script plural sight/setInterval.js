let i = 0 ;
const setIntFun = setInterval(printHello,1*1000)

function printHello(){    
    console.log('Hello World');
    ++i;
    if(i==5){
        console.log('Done')
        clearInterval(setIntFun)
    }
}
