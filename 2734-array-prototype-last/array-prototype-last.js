/**
 * @return {null|boolean|number|string|Array|Object}
 */
Array.prototype.last = function() {
    let ans;
    if(this.length==0)
        return -1;
    for(let i=0;i<this.length;i++)
        ans=this[i];
    return ans;
};

/**
 * const arr = [1, 2, 3];
 * arr.last(); // 3
 */