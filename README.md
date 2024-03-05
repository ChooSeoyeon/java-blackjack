# [블랙잭] 구현 기능 목록

## 블랙잭 용어

- 카드
    - Denomination(끗수): 2,3,4,5,6,7,8,9,10,J,Q,K,A
    - Suit(슈트): 스페이드, 하트, 다이아몬드, 클럽

- 액션
    - Hit(힛): 카드를 더 받겠다는 의미
    - Stand(스탠드): 카드를 그만 받겠다는 의미

- 결과
    - BlackJack(블랙잭): 첫 카드 두 장의 합이 21인 상황
        - 플레이어와 딜러가 둘다 블랙잭이면 비긴다
    - Bust(버스트): 숫자 카드의 합이 21이 넘어간 상황
        - 플레이어가 버스트면 즉시 패배한다
        - 딜러가 버스트면 모든 플레이어가 승리한다
        - 플레이어와 딜러가 둘 다 버스트면 플레이어가 승리한다
    - Push(푸시): 딜러 카드와 플레이어 카드의 합이 동점인 상황
        - 푸시면 플레이어가 승리한다

## 비즈니스 기능

1. [테이블 참가] 입력 받은 이름의 참여자들을 등록한다
    - 참여자 수는 1명 이상이다
    - 참여자 이름은 한 글자 이상이다 ✅
    - 참여자 이름은 중복될 수 없다
2. [카드 딜링] 딜러와 참여자들에게 카드를 2장씩 나누어 준다
    - 카드의 구성은 숫자 카드 2~10, King, Queen, Jack, Ace이다
    - 각 카드의 개수는 제한이 없다
    - BlackJack이면 액션이 진행되지 않는다
3. [플레이어 액션] 각 참여자들이 카드의 합을 맞추기 위해 카드를 더 받거나 그만 받는다
    - 21을 넘지 않을 경우 얼마든지 카드를 계속 뽑을 수 있다
    - 카드를 그만 받겠다는 의사 표현 이후 카드를 더 받을 수 없다
4. [딜러 액션] 딜러는 카드의 합이 17점 이상이 될 때까지 카드를 받는다
5. [게임 결과] 딜러와 플레이어들의 카드 합을 비교하여 승패를 가린다
    - 카드 합 계산은 카드 숫자를 기본으로 한다
    - Ace는 1 또는 11로 계산할 수 있으며, King, Queen, Jack은 각각 10으로 계산한다

## 입출력 기능

### 입력

1. 게임 참여자 이름을 쉼표(,)를 기준으로 구분해 입력한다
2. 각 참여자마다 Hit 혹은 Stand 여부를 y 혹은 n으로 입력 받는다

### 출력

1. [카드 딜링 결과]
    - 딜러는 카드를 한 장만 출력한다
    - 플레이어는 카드를 두 장 모두 출력한다
2. [플레이어 액션 결과] 카드를 더 받은 경우만 카드 목록을 출력한다
3. [딜러 액션 결과] 몇 번 카드를 더 받았는지 출력한다
4. [게임 결과]
    - 플레이어와 딜러의 최종 카드 목록과 카드 합을 출력한다
    - 플레이어와 딜러의 최종 승패를 출력한다
