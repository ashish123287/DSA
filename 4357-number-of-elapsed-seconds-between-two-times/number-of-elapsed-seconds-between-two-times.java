class Solution {
    public int secondsBetweenTimes(String startTime, String endTime) {
        int he = Integer.parseInt(endTime.substring(0,2));
        int hs = Integer.parseInt(startTime.substring(0, 2));
        int ms = Integer.parseInt(startTime.substring(3, 5));
        int me = Integer.parseInt(endTime.substring(3, 5));
        int ss = Integer.parseInt(startTime.substring(6, 8));
        int se = Integer.parseInt(endTime.substring(6, 8));
        if(se < ss){
            se += 60;
            me--;
        }
        if(me < ms){
            me += 60;
            he--;
        }
        return (he-hs)*60*60 + (me-ms)*60 + (se-ss);
    }
}