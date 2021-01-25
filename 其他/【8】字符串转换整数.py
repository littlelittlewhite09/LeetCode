class Solution:
    def myAtoi(self, s: str) -> int:
        automaton = Automaton()
        return automaton.get(s)

# 有限状态转移机（自动机）：在遍历字符串期间，存在多种状态：start(开始),signed(赋予符号),num_waited(等待输入数字),end(结束)，这些状态会根据当前的字符进行状态的转移。如处于start状态时，若输入的是'',则仍未start;若输入的是'+'或'-,则为'signed';若输入的是一个数字,则为'num_waited';若输入的是其他,则'end'

# res = 10 *res + int(char)
INT_MAX = 2**31 - 1
INT_MIN = -2**31

class Automaton:
    def __init__(self):
        self.curr_state = 'start'
        self.table = {'start':['start','signed','num_waited','end'],
        'signed':['end','end','num_waited','end'],
        'num_waited':['end','end','num_waited','end'],
        'end':['end','end','end','end']
        }
        self.signed = 1 
        self.res = 0

    def state_transform(self,char):
        if char.isspace():
            return 0 # 
        elif char == '+' or char == '-':
            return 1
        elif char.isdigit():
            return 2
        else:
            return 3
    
    def get(self, string):
        for char in string:
            self.curr_state = self.table[self.curr_state][self.state_transform(char)]
            if self.curr_state == 'signed':
                self.signed = 1 if char == '+' else -1
            if self.curr_state == 'num_waited':
                self.res = 10 * self.res + int(char) * self.signed
            elif self.curr_state == 'end':
                return  max(self.res,INT_MIN) if self.signed == -1 else min(self.res, INT_MAX)
        return  max(self.res,INT_MIN) if self.signed == -1 else min(self.res, INT_MAX)


        




