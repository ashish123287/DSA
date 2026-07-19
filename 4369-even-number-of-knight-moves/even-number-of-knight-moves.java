class Solution {
    public boolean canReach(int[] start, int[] target) {
        int x = target[0]+start[0];
        int y = target[1]+start[1];
        // in the every next step knight changes its colour so no. of steps will be even that means it finally reaches the same colour.
        return x%2 == y%2;
    }
}