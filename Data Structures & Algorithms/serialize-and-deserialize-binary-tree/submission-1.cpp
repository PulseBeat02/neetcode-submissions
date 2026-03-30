/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */

class Codec {
public:

    // Encodes a tree to a single string.
    string serialize(TreeNode* root) {
        if (!root) return "";
        vector<string> ans;
        dfs(ans, root);
        string res;
        for (string& str : ans) {
            res.append(str);
            res.append(",");
        }
        res.pop_back();
        return res;
    }

    void dfs(vector<string>& res, TreeNode* root) {
        if (!root) {
            res.push_back("N");
            return;
        }
        res.push_back(to_string(root->val));
        dfs(res, root->left);
        dfs(res, root->right);
    }

    // Decodes your encoded data to tree.
    vector<string> split(string& data) {
        vector<string> result;
        stringstream ss(data);
        string item;
        while (getline(ss, item, ',')) {
            result.push_back(item);
        }
        return result;
    }

    TreeNode* deserialize(string data) {

        if (data.empty()) return nullptr;

        vector<string> res = split(data);
        TreeNode* root = nullptr;
        int index = 0;
        helper(res, root, index);

        return root;
    }

    void helper(vector<string>& data, TreeNode*& current, int& index) {
        if (index >= data.size() || data[index] == "N") {
            current = nullptr;
            index++;
            return;
        }
        current = new TreeNode(stoi(data[index]));
        index++;
        helper(data, current->left, index);
        helper(data, current->right, index);
    }
};





