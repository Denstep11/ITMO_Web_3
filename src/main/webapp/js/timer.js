function updateDate(){
    let currentTime = new Date()
    let hours = currentTime.getHours()
    let minutes = currentTime.getMinutes()
    let seconds = currentTime.getSeconds()
    let year = currentTime.getFullYear()
    let month = currentTime.getMonth()
    let day = currentTime.getDate()
    month++
    if (minutes < 10){
        minutes = "0" + minutes
    }
    if (seconds < 10){
        seconds = "0" + seconds
    }
    let timer_str = hours + ":" + minutes + ":" + seconds;
    let date_str = day + ":" + month + ":" + year;
    document.getElementById('time').innerHTML = timer_str;
    document.getElementById('date').innerHTML = date_str;
}
updateDate();
setInterval(updateDate, 7000);