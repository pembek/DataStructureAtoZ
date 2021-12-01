DIRECTIONS = [
    (1, 0),
    (-1, 0),
    (0, 1),
    (0, -1),
]


def max_words(board, n, m, words, visited, r, c, curr_word):
    if r < 0 or r >= n or c < 0 or c >= m or visited[r][c]:
        return []

    curr_word += board[r][c]
    # if no words in |words| start with |curr_word|, then return early.
    if not any(word.startswith(curr_word) for word in words):
        return []

    visited[r][c] = True

    max_word_set = []
    if curr_word in words:
        # A valid words has been found: terminate current word search and start a new one
        for r, row in enumerate(board):
            for c, val in enumerate(row):
                curr_word_set = max_words(board, n, m, words, visited, r, c, '')
                if len(curr_word_set) > len(max_word_set):
                    max_word_set = curr_word_set
        max_word_set.append(curr_word)
    else:
        for dr, dc in DIRECTIONS:
            curr_word_set = max_words(board, n, m, words, visited, r + dr, c + dc, curr_word)
            if len(curr_word_set) > len(max_word_set):
                max_word_set = curr_word_set

    visited[r][c] = False
    return max_word_set


def find_max_words(board, words):
    if not board:
        return 0

    n, m = len(board), len(board[0])
    visited = [[False for _ in range(m)] for _ in range(n)]
    max_words_so_far = []

    for r, row in enumerate(board):
        for c, val in enumerate(row):
            word_set = max_words(board, n, m, words, visited, r, c, '')
            if len(word_set) > len(max_words_so_far):
                max_words_so_far = word_set

    print(max_words_so_far)
    return len(max_words_so_far)