function printHello(number){
    console.log('Hello after '+number+' seconds');
}

setTimeout(printHello,4*1000,'4');
setTimeout(printHello,8*1000,'8');