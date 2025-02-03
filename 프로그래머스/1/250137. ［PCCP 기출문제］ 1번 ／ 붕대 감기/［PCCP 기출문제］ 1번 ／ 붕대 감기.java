class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int maxHealth = health;
        int fullTime = bandage[0];
        int heal = bandage[1];
        int addHeal = bandage[2];
        
        int lastAttackTime=0;
        for(int[] attack : attacks) {
            int attackTime = attack[0];
            int damage=attack[1];
            int term = attackTime-lastAttackTime;
            // term==1 바로 맞음. term>1 회복하고 맞음. term이 bandage0 보다 크면 추가회복 같으면안됨.
            if(term>fullTime) {
                health += (((term-1)/fullTime)*addHeal + ((term-1)*heal));
            } else if(term>1) {
                health+=((term-1)*heal);
            }
            health = Math.min(health, maxHealth);
            
            health-=damage;
            
            if(health<=0) {
                health=-1;
                break;
            }
            lastAttackTime = attackTime;
        }
        return health;
    }
}

/*
1 2 3 4 5 6 7 8 9 
1 2 3 4 1 2 3 4 공격
*/