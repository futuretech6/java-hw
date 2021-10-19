class ArrayIntegerStack implements IntegerStack {
    private int capacity;
    private int top = 0;
    private Integer[] arrStack;
    /* 其他代码 */
    /* 你的答案，即3个方法的代码 */

    public Integer push(Integer item) { // 如果item为null，则不入栈直接返回null。如果栈满，抛出FullStackException（系统已有的异常类）。
        if (item.equals(null))
            return null;
        else if (capacity == top)
            throw new FullStackException();
        arrStack[top] = item;
        top++;
        return item;
    }

    public Integer pop() { // 出栈。如果栈空，抛出EmptyStackException，否则返回
        if (top == 0)
            throw new EmptyStackException();
        top--;
        return arrStack[top];
    }

    public Integer peek() { // 获得栈顶元素。如果栈空，抛出EmptyStackException。
        if (top == 0)
            throw new EmptyStackException();
        return arrStack[top - 1];
    }

    /* 你的答案，即3个方法的代码 */
}
