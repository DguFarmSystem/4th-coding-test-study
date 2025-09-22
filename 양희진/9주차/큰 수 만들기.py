def solution(number, k):
    lst = []

    for i in number:
        # 큰 수가 앞에 저장될 수 있도록 새로 넣으려는 수보다 앞에 저장했던 수가 작으면 저장된 수를 삭제
        # 리스트가 비어있지 않아야 함
        # k만큼 제거를 다 하면 남은 수 모두 추가
        while lst and lst[-1] < i and k > 0: 
            lst.pop()  
            k -= 1        
        lst.append(i)  

    if k > 0:
        lst = lst[:-k]
    return ''.join(lst)
