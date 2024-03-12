# A. 블랙잭 게임 설명

- [TWOWIN GAMES](https://2wingames.com/guide/blackjack/rule) 의 룰과 거의 유사하지만, 부분적으로 다른 부분이 존재합니다.

## 게임 진행

1. 게임 참가: 플레이어들은 이름을 입력하면 게임에 참여할 수 있습니다.
2. 카드 딜링: 딜러와 플레이어에게 각각 카드 2장씩을 나눠줍니다.
    - 이때, 딜러의 카드는 1장만 오픈, 플레이어의 카드는 2장 모두 오픈합니다.
3. 플레이어 액션: 플레이어들이 차례대로 액션을 진행합니다.
    - 플레이어는 숫자합을 맞추기 위해 카드를 더 받거나 그만 받을 수 있습니다.
4. 딜러 액션: 모든 플레이어의 액션이 끝나면 딜러의 액션을 진행합니다.
    - 딜러는 카드 숫자합이 17미만인 경우 무조건 카드 1장을 추가로 받으며, 그 이상인 경우 카드를 그만 받습니다.
5. 결과: 딜러의 카드 숫자합과 플레이어들의 카드 숫자합을 각각 비교하여 높은 쪽이 승리합니다.
    - A는 1또는 11로 계산하며, J,Q,K는 10으로 계산합니다.

## 블랙잭 용어

- 카드
    - Denomination(끗수): 2,3,4,5,6,7,8,9,10,J,Q,K,A
    - Suit(슈트): 스페이드, 하트, 다이아몬드, 클럽
    - Hand(핸드)(=Cards): 카드 패 뭉치

- 액션
    - Draw(드로우): 카드를 1장 더 받겠다는 의미
    - Stand(스탠드): 카드를 그만 받겠다는 의미

- 이벤트
    - BlackJack(블랙잭): 첫 카드 두 장의 합이 21인 상황
        - 플레이어와 딜러가 둘다 블랙잭이면 비깁니다
    - Bust(버스트): 숫자 카드의 합이 21이 넘어간 상황
        - 플레이어가 버스트면 플레이어는 즉시 패배합니다
        - 딜러가 버스트면 버스트가 아닌 모든 플레이어가 승리합니다
        - 플레이어와 딜러가 둘 다 버스트면 딜러가 승리합니다

## 게임 결과

- 승리: 베팅 금액을 돌려받고 베팅 금액의 1배를 추가로 받습니다.
    - 플레이어 카드가 딜러 카드의 `숫자합보다 높다면` 승리합니다.
    - 플레이어가 `버스트되지 않은 상태에서 딜러가 버스트` 된 경우 승리합니다.
- 패배: 베팅 금액을 잃습니다.
    - 플레이어 카드가 딜러 카드의 `숫자합보다 낮다면` 패배합니다.
    - 플레이어가 `버스트 된 경우` 딜러의 버스트 여부에 상관 없이 패배합니다.
    - 플레이어가 `블랙잭이 아니고 딜러가 블랙잭`이라면 패배합니다.
- 푸시(무승부): 베팅 금액을 돌려받습니다.
    - 플레이어 카드가 딜러 카드의 `숫자합과 동일하면` 무승부가 됩니다.
    - 플레이어와 딜러 `모두 블랙잭`인 경우 무승부가 됩니다.
- 블랙잭 승리: 베팅 금액을 돌려받고 베팅 금액의 1.5배를 추가로 받습니다.
    - 플레이어가 `블랙잭이고 딜러가 블랙잭이 아니라면` 블랙잭 승리입니다.

## 승패 결정 경우의 수

### 플레이어 입장에서 요약

- 카드 딜링 이후: 카드 두 장일 때
    - 플레이어만 블랙잭 -> 블랙잭 승리
    - 딜러만 블랙잭 -> 패배
    - 플레이어랑 딜러 둘다 블랙잭 -> 푸시
    - 플레이어랑 딜러 둘다 블랙잭 아님 -> 액션(스탠드, 힛)으로 넘어가기
- 액션 이후: 카드 두 장 이상일 때
    - 플레이어만 버스트 -> 패배
    - 딜러만 버스트 -> 승리
    - 플레이어랑 딜러 둘다 버스트 -> 패배
    - 플레이어랑 딜러 둘다 버스트 아님 -> 카드합이 21에 더 가까우면 승리, 카드합이 같으면 푸시

### 카드 딜링 이후: 카드 두 장일 때

초반에 모두가 2장씩 나눠가졌을 때 발생할 수 있는 경우의 수는 아래와 같습니다.

참고로 초반에 두 장씩만 나눠 가졌을 땐 파산(카드 합이 22 이상)이 나올 수 없어 파산을 고려하지 않아도 됩니다.

|       | 상황 a  | 상황 b  | 상황 c  | 상황 d  | 상황 e  | 상황 f  |
|-------|-------|-------|-------|-------|-------|-------|
| 딜러    | 블랙잭 o | 블랙잭 o | 블랙잭 o | 블랙잭 x | 블랙잭 x | 블랙잭 x |
| 플레이어1 | 블랙잭 x | 블랙잭 o | 블랙잭 o | 블랙잭 o | 블랙잭 o | 블랙잭 x |
| 플레이어2 | 블랙잭 x | 블랙잭 x | 블랙잭 o | 블랙잭 o | 블랙잭 x | 블랙잭 x |

1. 상황 a, b, c ➡️ 딜러가 블랙잭일 땐, 플레이어들이 비길 수 있는 방법은 본인들도 `블랙잭(첫 카드 두 장 합이 21 이상)`인 경우밖에 없습니다. 따라서, `코드를 더 뽑을 필요 없이`
   플레이어들이 `현재 가지고 있는 두 장의 카드들만 살펴보면` 승부를 결정지을 수 있습니다.
2. 상황 c, d ➡️ 플레이어 모두가 블랙잭일 땐, 딜러가 비길 수 있는 방법은 본인도 `블랙잭(첫 카드 두 장 합이 21 이상)`인 경우 밖에 없습니다. 따라서, `코드를 더 뽑을 필요 없이`
   딜러가 `현재 가지고 있는 두 장의 카드만 살펴보면` 승부를 결정지을 수 있습니다.
3. 상황 e ➡️ 딜러가 블랙잭이 아닌데 플레이어 일부가 블랙잭일 땐, 딜러와 플레이어1 사이엔 승부가 결정되었더라도, 딜러와 플레이어2 사이엔 승부가 결정되지 않았기에 그들끼리 승부를 더 겨룰 수 있게끔 카드를
   더 뽑게 합니다.
4. 상황 f ➡️ 딜러와 플레이어 모두가 블랙잭이 아닐 땐, 카드를 더 뽑게 합니다.

### 플레이어/딜러 액션 이후: 카드 두 장 이상일 때

승패가 결정되는 경우의 수는 아래와 같습니다.
초반에 블랙잭이 안나오고, 카드를 추가적으로 뽑았을 때(카드 두 장 이상)를 전제합니다.

|      | 상황 a | 상황 b | 상황 c | 상황 d   | 상황 e   | 상황 f   |
|------|------|------|------|--------|--------|--------|
| 딜러   | 20   | 20   | 21   | 22(파산) | 21     | 22(파산) |
| 플레이어 | 21   | 20   | 20   | 21     | 22(파산) | 22(파산) |

1. 상황 a, b, c ➡️ 파산을 고려할 필요 없이 오직 21에 가까운 지 여부로만 승부가 결정됩니다. 21에 더 가까운 이가 승리합니다. 플레이어와 딜러가 21에 가까운 정도가 똑같다면 비깁니다.
2. 상황 d, e ➡️ 파산을 한 쪽이 무조건 지는 것으로 승부가 결정됩니다.
3. 상황 f ➡️ 딜러가 무조건 승리하는 것으로 승부가 결정됩니다.

# B. 블랙잭 구현 기능 목록

## 비즈니스 기능

1. [테이블 참가] 입력 받은 이름의 참여자들을 등록한다 ✅
    - 참여자 수는 1명 이상이다 ✅
    - 참여자 이름은 한 글자 이상이다 ✅
    - 참여자 이름은 중복될 수 없다 ✅
2. [카드 딜링] 딜러와 참여자들에게 카드를 2장씩 나누어 준다 ✅
    - 카드는 끗수와 슈트의 조합이다 ✅
    - 각 카드의 개수는 제한이 없다 ✅
    - BlackJack이면 액션이 진행되지 않는다 ✅
3. [플레이어 액션] 각 참여자들이 카드의 합을 맞추기 위해 카드를 더 받거나 그만 받는다 ✅
    - 21을 넘지 않을 경우 얼마든지 카드를 계속 뽑을 수 있다 ✅
    - 카드를 그만 받겠다는 의사 표현 이후 카드를 더 받을 수 없다
4. [딜러 액션] 딜러는 카드의 합이 17점 이상이 될 때까지 카드를 받는다 ✅
5. [게임 결과] 딜러와 플레이어들의 카드 합을 비교하여 승패를 가린다 ✅
    - 카드 합 계산은 카드 숫자를 기본으로 한다 ✅
    - Ace는 1 또는 11로 계산할 수 있으며, King, Queen, Jack은 각각 10으로 계산한다 ✅

## 입출력 기능

### 입력

1. 게임 참여자 이름을 쉼표(,)를 기준으로 구분해 입력한다 ✅
2. 각 참여자마다 Draw 혹은 Stand 여부를 y 혹은 n으로 입력 받는다 ✅

### 출력

1. [카드 딜링 결과]
    - 딜러는 카드를 한 장만 출력한다 ✅
    - 플레이어는 카드를 두 장 모두 출력한다 ✅
2. [플레이어 액션 결과] 카드를 더 받은 경우만 카드 목록을 출력한다 ✅
3. [딜러 액션 결과] 몇 번 카드를 더 받았는지 출력한다 ✅
4. [게임 결과]
    - 플레이어와 딜러의 최종 카드 목록과 카드 합을 출력한다 ✅
    - 플레이어와 딜러의 최종 승패를 출력한다 ✅

# C. 부록

## 우리가 정한 컨벤션

- 변수에 final 붙이는 기준
    - 불변 여부가 변경하지 않는다는 사실이 자명할 때 -> final을 붙임
        - controller가 view와 model로부터 받은 것엔 final 붙이기
        - 매개변수를 함수 내에서 건들지 않을 땐 final 붙이기
            - 함수를 호출하는 외부에선 함수한테 매개변수로 넘겨준 값이 변경되는지 알지 못하기 때문에 (변경되는 걸 기대하지 않을 수 있기에)
            - 매개변수가 함수 내에서 변경되는 걸 지양해야 한다
    - 기능 변경으로 나중엔 불변/가변 여부가 변경될 수 있을 때 -> final 을 안붙임
        - 일반적인 지역 변수를 사용할 때 final 붙이지 않기

- 생성자 테스트 작성 기준
    - 생성자에서 검증 로직이 있고 검증에 실패했을 때 예외를 던진다면, 올바른 값이 들어갔을 때 예외가 발생하지 않는지 테스트 작성해 확인
    - 생성자에서 값을 변경하는 로직이 있을 때, 값이 의도한 대로 저장이 되었는지 테스트 작성해 확인
        - ex) card 생성 로직에는 랜덤한 숫자를 enum(끗수, 슈트)으로 변경한다

- dto-model 매핑 로직 위치
    - `model이 dto의 구조를 아는 것` -> dto가 변경됐을 때 model이 변경되어야 함
    - `dto가 model의 구조를 아는 것` -> model이 변경됐을 때 dto가 변경되어야 함
        - dto가 더 변경에 취약한 친구이기에 `dto가 model의 구조를 알게` 끔 구성하기

## 도메인 이해를 위한 메모

- 플레이어 vs 딜러
    - 공통점
        - 처음에 카드를 두 장씩 받는다
        - 카드를 추가로 받았다 때 합이 21 초과면 바로 승부가 결정된다
        - 가진 카드의 합을 계산한다
    - 차이점
        - 카드를 추가로 받을 때
            - 플레이어는 카드 합이 (21 이하)면 카드를 받을 수 있다
                - 카드를 받는 걸 (선택)할 수 있다
            - 딜러는 카드 합이 (16 이하)면 카드를 받을 수 있다
                - 17 이상이 될 때까지 (반드시) 카드를 받는다

- 카드를 주는 쪽과 받는 쪽
    - 받는 쪽 : cards
    - 주는 쪽 : 후에 필요시 생성하기 -> cardGenerator

- ace 취급
    - (전제) 합이 22보다 크면 ace를 11로 계산했던 걸 1로 취급해서 10을 빼자 -> 합이 21보다 크면 ace는 1로 계산됨
    - (반전) 합이 21보다 작으면 ace를 1로 계산했던 걸 11로 취급해서 10을 더하자 -> 합이 21보다 작거나 같으면 ace는 11로 계산됨
