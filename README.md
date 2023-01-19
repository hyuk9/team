# Delicious-Tomato

> **맛있는 토마토 프로젝트**
- 기간 : 2022.12.19 ~ 2023.01.11
- 팀장 : 장동혁 (https://github.com/hyuke0816)
- 팀원 
  - 권태현 (https://github.com/Messier-81)
  - 박선영 (https://github.com/julysy)
  - 전성혜 (https://github.com/eodalzh)
  - 조성모 (https://github.com/JoSeongmo)
---
> **프로젝트 소개**
> 
- 사용자 친화적 & 맞춤형 맛집 추천 사이트를 제작하고자 했습니다.
---
> **기존 문제점**
> 
- 사용자는 사이트에서 제공하는 정보만 일방향적으로 받는 사이트들이 대부분이었습니다.
- 사용자 평점이 세분화 되어있지 않고 하나로 되어있는 경우가 많아서 다방면에 대한 평가는 리뷰를 읽어봐야 알 수 있었습니다.
---

> **개선점**
> 
- 커뮤니티 기능을 추가하여 단순히 사이트에서만 제공하는 정보 뿐만이 아닌 사용자들 간의 정보 공유를 가능하게 설계했습니다.
- 사용자 평점을 세분화하여 차트로 나타내어 사용자가 어떤 부분에서 만족/불만족을 느꼈는지 바로 확인할 수 있게 설계했습니다.
---

> **기술스택**

- FrontEnd
    - `Vue.js`
    - `Node.js`
    - `Bootstrap5`
    - `Vee validate`
- BackEnd
    - `Spring Security`
    - `lombok`
    - `JWT`
    - `Gradle`
    - `JPA`
- DataBase
    - `MySQL`
    - `ORACLE DATABASE`
- Configuration Management
    - `GitHub`
---

> **핵심기능 및 서비스** 

- `chart.js` : 사용자 평점을 통한 각 음식점 평가 차트 구현
- `bootstrap5` : 전반적인 사이트 레이아웃 구현
- `JWT login` : JWT 토큰을 이용한 사이트 자체 로그인 기능 구현
- `social login`
    - `Google login API`
    - `Naver login API`
    - `Kakao login API`
- `Kakao map API` : 각 음식점 위치 구현

---
> **회고**
> 
- 음식점 리뷰를 모든 사용자가 쓸 수 있는 문제가 있습니다. 향후 해당 음식점을 이용한 사람만 리뷰를 남길 수 있게 개선할 예정입니다.
- 프로젝트 초기에 테이블 설계를 꼼꼼히 하지 않으면 전체적인 작업 진행도에 영향이 미치는 문제가 발생하는 것을 체감했습니다.
