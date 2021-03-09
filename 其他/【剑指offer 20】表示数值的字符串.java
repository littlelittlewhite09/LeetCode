class Solution {
    enum State {//当前状态
        STATE_INITIAL,//初始化状态
        STATE_INT_SIGN,//符号装填
        STATE_INTEGER,//整数状态
        STATE_POINT,//小数点左侧有数
        STATE_POINT_WITHOUT_INT,//小数点左侧没有数
        STATE_FRACTION,//小数状态
        STATE_EXP,//指数状态
        STATE_EXP_SIGN,//指数符号
        STATE_EXP_NUMBER,//指数整数
        STATE_END//结束状态
    }

    enum CharType {//当前字符
        CHAR_NUMBER,//整数
        CHAR_EXP,//指数
        CHAR_POINT,//小数点
        CHAR_SIGN,//符号
        CHAR_SPACE,//空格
        CHAR_ILLEGAL//非法字符
    }
    public boolean isNumber(String s) {
        //状态转移
        Map<State, Map<CharType, State>> transfer = new HashMap<State, Map<CharType, State>>();

        //初始状态的转移
        Map<CharType, State> initialMap = new HashMap<CharType, State>() {{
            put(CharType.CHAR_SPACE, State.STATE_INITIAL);
            put(CharType.CHAR_NUMBER, State.STATE_INTEGER);
            put(CharType.CHAR_POINT, State.STATE_POINT_WITHOUT_INT);
            put(CharType.CHAR_SIGN, State.STATE_INT_SIGN);
        }};
        transfer.put(State.STATE_INITIAL, initialMap);

        //符号状态的转移
        Map<CharType, State> intSignMap = new HashMap<CharType, State>() {{
            put(CharType.CHAR_NUMBER, State.STATE_INTEGER);
            put(CharType.CHAR_POINT, State.STATE_POINT_WITHOUT_INT);
        }};
        transfer.put(State.STATE_INT_SIGN, intSignMap);

        //整数状态的转移
        Map<CharType, State> integerMap = new HashMap<CharType, State>() {{
            put(CharType.CHAR_NUMBER, State.STATE_INTEGER);
            put(CharType.CHAR_EXP, State.STATE_EXP);
            put(CharType.CHAR_POINT, State.STATE_POINT);
            put(CharType.CHAR_SPACE, State.STATE_END);
        }};
        transfer.put(State.STATE_INTEGER,integerMap);

        //小数点左侧有数状态的转移
        Map<CharType, State> pointMap = new HashMap<CharType, State>() {{
            put(CharType.CHAR_NUMBER, State.STATE_FRACTION);
            put(CharType.CHAR_EXP, State.STATE_EXP);
            put(CharType.CHAR_SPACE, State.STATE_END);
        }};
        transfer.put(State.STATE_POINT,pointMap);

        //小数点左侧没有数状态的转移
        Map<CharType, State> pointWithoutIntMap = new HashMap<CharType, State>() {{
            put(CharType.CHAR_NUMBER, State.STATE_FRACTION);
        }};
        transfer.put(State.STATE_POINT_WITHOUT_INT, pointWithoutIntMap);

        //小数部分状态的转移
        Map<CharType, State> fractionMap = new HashMap<CharType, State>() {{
            put(CharType.CHAR_NUMBER, State.STATE_FRACTION);
            put(CharType.CHAR_EXP, State.STATE_EXP);
            put(CharType.CHAR_SPACE, State.STATE_END);
        }};
        transfer.put(State.STATE_FRACTION, fractionMap);

        //指数状态的转移
        Map<CharType, State> expMap = new HashMap<CharType, State>() {{
            put(CharType.CHAR_NUMBER, State.STATE_EXP_NUMBER);
            put(CharType.CHAR_SIGN, State.STATE_EXP_SIGN);
        }};
        transfer.put(State.STATE_EXP, expMap);

        //指数符号状态的转移
        Map<CharType, State> expSignMap = new HashMap<CharType, State>() {{
            put(CharType.CHAR_NUMBER, State.STATE_EXP_NUMBER);
        }};
        transfer.put(State.STATE_EXP_SIGN, expSignMap);

        //指数整数状态的转移
        Map<CharType, State> expNumberMap = new HashMap<CharType, State>() {{
            put(CharType.CHAR_NUMBER, State.STATE_EXP_NUMBER);
            put(CharType.CHAR_SPACE, State.STATE_END);
        }};
        transfer.put(State.STATE_EXP_NUMBER, expNumberMap);

        //结束状态的转移
        Map<CharType, State> endMap = new HashMap<CharType, State>() {{
            put(CharType.CHAR_SPACE, State.STATE_END);
        }};
        transfer.put(State.STATE_END, endMap);

        int len = s.length();
        State state = State.STATE_INITIAL;
        for(int i = 0;i < len;i++){
            CharType c = toCharType(s.charAt(i));
            if(!transfer.get(state).containsKey(c)){//在当前状态下，检查是否含有相应CharType，如果没有则不是一个数
                return false;
            }
            state = transfer.get(state).get(c);
        }

        //遍历完整个字符串后，当state为整数状态、小数点左侧有数状态、小数部分状态、指数整数部分、结束状态时，该字符串为数
        return state == State.STATE_INTEGER || state == State.STATE_POINT || state == State.STATE_FRACTION || state == State.STATE_EXP_NUMBER || state == State.STATE_END;
    }


    //将原字符串中的字符转为CharType
    public CharType toCharType(char c){
        if(c >= '0' && c <= '9'){
            return CharType.CHAR_NUMBER;
        }else if(c == '.'){
            return CharType.CHAR_POINT;
        }else if(c == ' '){
            return CharType.CHAR_SPACE;
        }else if(c == 'e' || c == 'E'){
            return CharType.CHAR_EXP;
        }else if(c == '+' || c == '-'){
            return CharType.CHAR_SIGN;
        }else{
            return CharType.CHAR_ILLEGAL;
        }


    }
}
