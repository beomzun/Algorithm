import java.util.*;
class Solution {
    public String[] solution(String[] s) {
        String[] answer = new String[s.length];
        
        for(int i=0;i<s.length;i++) {
            StringBuilder sb = new StringBuilder();
            int count = 0;
            
            for(int j=0;j<s[i].length();j++) {
                char c = s[i].charAt(j);
                sb.append(c);
                if(sb.length()>=3 && sb.charAt(sb.length()-3) == '1'
                   && sb.charAt(sb.length()-2)=='1' && sb.charAt(sb.length()-1)=='0') {
                    count++;
                    sb.delete(sb.length()-3, sb.length());
                }
            }
            
            String chunk = "110".repeat(count);
            int lastZero = sb.lastIndexOf("0");
            
            StringBuilder result = new StringBuilder();
            if(lastZero==-1) {
                result.append(chunk).append(sb);
            } else {
                result.append(sb.substring(0,lastZero+1))
                    .append(chunk)
                    .append(sb.substring(lastZero+1));
            }
            
            answer[i] = result.toString();
        }
        
        return answer;
    }
}
/*
배열 길이 백만 
각 문자열 백만
모든 원소 길이의 합 백만 = s.length * avg(s[i].length) <= 백만
---
각 문자열 별로 앞에서부터 탐색.
- 111 존재 시, 바꿔야할 지점으로 첫 인덱스 저장. 해당 인덱스의 앞에 삽입.
- 110 발견 시, 바꿔야할 지점으로 변경. 없으면 패스.
111 이전까지 자르기 + 110 붙이기 + 111시작부터 110 시작 인덱스 서브문자열 + 110 이후 문자열
---
substring, indexOf 패착 & 1100 -> 1100 반례 0110으로.
---
스택으로 110 다 빼서 삽입하기. 0<110<1 => 이게 킥이었음.

Integer->Boolean 이면 메모리 절약할수있지않나? X
참조형 객체는 객체 해더+실제 데이터로 이루어짐 + (JVM은 객체 크기를 8배수로 관리한다.)
=> 헤더 12바이트 + 실제 데이터(4바이트, 1바이트) => 16, 13바이트 => 결국 16바이트
=> Boolean 실제 데이터 1비트 아님? -> 1비트인데, 메모리는 바이트 단위로 주소관리함 => CPU가 메모리에서 데이터 읽어올때 최소 단위가 바이트. 1비트여도 나머지 빈공간으로 boolean 만듦. BitSet(1바이트 안에 boolean 8개 욱여넣기)
객체 하나 생성 시 힙에 16바이트, 스택에 4바이트(주소값)

인스턴트(Instant=객체) 캐싱 - Integer, Boolean
Boolean 변수는 Boolean.TRUE / Boolean.FALSE 두 개 미리 만들어두고 돌려씀. 그래서 실제 메모리는 거의 늘지않음.
Integer 변수는 -128~127까지 캐싱함. 이 범위를 벗어나면 매번 16바이트 생성하므로 메모리 Leak.
*/