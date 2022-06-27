/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
  //TC O(m+n) SC O(1)
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==headB)return headA;
        
        ListNode temp=null;
        
        int lenA=0;
        int lenB=0;
        temp=headA;
        while(temp!=null){
            lenA++;
            temp=temp.next;
        }
        temp=headB;
        while(temp!=null){
            lenB++;
            temp=temp.next;
        }
        int diff =lenA-lenB;
        ListNode tempA=headA;
        ListNode tempB=headB;
        if(diff<0) //means A's length small, mpove to diff num of positions in longer list
        {
            //move to diff num of positions in  B
            while(diff++ != 0)
            tempB=tempB.next;
            
            if(tempB==tempA)return tempB;
            
        while(lenB--!=0 ){
            if(tempA.next==tempB.next)return tempA.next;
            tempA=tempA.next;
            tempB=tempB.next;
        }
        }
        else if (diff>0){
            
            //move to diff num of positions in  A
            while(diff-- != 0)
            tempA=tempA.next;
            
            if(tempB==tempA)return tempB;
            
        while(lenA--!=0){
            if(tempA.next==tempB.next)return tempA.next;
            tempA=tempA.next;
            tempB=tempB.next;
         }
        }
        else{ //equal length lists
            tempA=headA;
            tempB=headB;
            
            while(tempA!=null){
                
            if(tempA.next==tempB.next)return tempA.next;
                tempA=tempA.next;
                tempB=tempB.next;
            
            }
            return null;
        }
        
        
        return null;
    }
}
