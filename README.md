<h1>달맹의 서브 프로젝트 Dalmengs' Sub Project</h1>
<h2>데이터베이스 키 - Database Key</h2>
<a href="http://dalmeng-commeng.tistory.com">달맹의 개발 블로그 - Dalmeng's Development Diary</a>
<hr>
<h3>Project Description</h3>
While structuring online judge project, I had confused to distinguish concepts of database key.<br><br>
Especially, I had trouble in two functions:<br>
<ol>
<li>favorite function in board</li>
<li>submit function in programming problem</li>
</ol>
This two situations are similar in view of relationship between tables, but have different business logic.<br><br>
In former case, even if user presses favorite button several times, a favorite count only increases once.<br>That is, same tuple (boardId, userId) can't exist in one table simultaneously.<br><br>
But latter case, one user can submit many times in one problem.<br>Because tuple (problemId, userId) is not a minimum identifier, they are treated as a different data.<br><br>
To distinguish upper cases, understanding database key is totally important.<br><br>
From table structuring to test, you can view all of  processes.<br>
It will be very helpful for many business model implementation.<br><br>
Link : <a href="http://dalmeng-commeng.tistory.com/3">Episode #1. Database Key</a><br>
(All Contents have been written in Korean.)

<hr>
<h3>프로젝트 설명</h3>
온라인 저지를 설계하던 중, 데이터베이스 키에 대한 개념이 굉장히 헷갈렸습니다.<br><br>
특히 아래 두 가지 기능을 설계하면서 어려움을 겪었습니다.<br>
<ol>
<li>게시판의 좋아요 기능</li>
<li>프로그래밍 문제의 제출 기능</li>
</ol>
두 기능은 테이블 간 관계의 관점에서 보면 비슷하지만, 비즈니스 로직의 관점에서 보면 다릅니다.<br><br>
전자의 경우, 한 사용자가 좋아요 버튼을 여러 번 누른다고 좋아요 횟수가 2가 증가하지 않습니다.<br>즉, 튜플 (boardId, userId)에 대하여 같은 튜플은 동시에 저장될 수 없음을 의미합니다.<br><br>
하지만 후자의 경우에는 한 사용자가 한 문제에 대해 여러 번 제출할 수 있습니다.<br>튜플 (boardId, userId)이 최소 식별자가 아니기 때문에 튜플의 구성이 어떻든 다른 데이터로 여겨집니다.<br><br>
이 두 기능을 구분하기 위해서는 데이터베이스 키를 이해하는 것이 매우 중요합니다.<br><br>
테이블 구조 설계부터 테스트까지 모든 과정을 확인하실 수 있습니다.<br>
굉장히 흔한 데이터 모델이기도 한 만큼 여러 프로젝트에 활용할 수 있을 것입니다.<br><br>

링크 : <a href="http://dalmeng-commeng.tistory.com/3">데이터베이스 키 1편</a>
