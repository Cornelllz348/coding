# 100. Same Tree *

# Given two binary trees, write a function to check if they are the same or not.
# Two binary trees are considered the same if they are structurally identical and the nodes have the same value.

# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

def isSameTree(p, q):
    """
    :type p: TreeNode
    :type q: TreeNode
    :rtype: bool
    """
    # if p and q are both None, return True
    if not p and not q:
        return True
    # if one of p and q is None, return False
    if not p or not q:
        return False
    # if p.val is not q.val, return False
    if p.val != q.val:
        return False
    # recursively check the left subtree and the right subtree
    return self.isSameTree(p.right, q.right) and self.isSameTree(p.left, q.left)

# Method: Tree, DFS
# Time: O(N) where N is the total number of nodes in the tree
# Space: best case O(logN) for a perfectly balanced tree; worst case O(N) for a completely unbalanced tree
