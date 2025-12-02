<template>
  <div>
    <div class="newadd">
      <el-button type="primary" @click="dialogVisible = true">
        新增属性
      </el-button>
    </div>
    <el-dialog
      title="属性名称"
      :visible.sync="dialogVisible"
      width="30%"
      :before-close="handleClose"
    >
      <div class="newadditem">
        <span>属性名称：</span>
        <el-input
          v-model="attributeName"
          placeholder="请输入属性名称"
        ></el-input>
      </div>
      <div class="newadditem">
        <span>排序</span>
        <el-input
          v-model="attributeSort"
          placeholder="请输入排序"
          oninput="value=value.replace(/[^\d]/g,'')"
        ></el-input>
      </div>
      <span slot="footer" class="dialog-footer">
        <el-button @click="dialogVisible = false">取 消</el-button>
        <el-button type="primary" @click="clickAdd"> 确 定 </el-button>
      </span>
    </el-dialog>
    <el-table
      ref="multipleTable"
      :data="tableData"
      tooltip-effect="dark"
      style="width: 100%"
      border
      align="center"
      :header-cell-style="{ background: '#e4e4e4' }"
    >
      <el-table-column type="selection" width="80" align="center">
      </el-table-column>
      <el-table-column label="属性ID" align="center">
        <template slot-scope="scope">{{ scope.row.id }}</template>
      </el-table-column>
      <el-table-column prop="name" label="属性名称" width="200" align="center">
      </el-table-column>
      <el-table-column
        prop="attrCount"
        label="规格数量"
        width="140"
        align="center"
      >
      </el-table-column>
      <el-table-column prop="sort" label="排序" width="140" align="center">
      </el-table-column>
      <el-table-column label="设置" width="200" align="center">
        <template slot-scope="scope"
          ><el-button
            size="small"
            type="primary"
            @click="goSpeci(scope.row)"
            plain
            >规格列表</el-button
          ></template
        >
      </el-table-column>
      <el-table-column fixed="right" label="操作" width="200" align="center">
        <template slot-scope="scope">
          <el-button
            @click="handleClick(scope.row)"
            type="primary"
            size="small"
            plain
            >编辑</el-button
          >
          <el-button type="danger" size="small" @click="delList(scope.row)"
            >删除</el-button
          >
        </template>
      </el-table-column>
    </el-table>
    <!-- <div style="margin-top: 20px">
      <el-button @click="toggleSelection([tableData[1], tableData[2]])"
        >切换第二、第三行的选中状态</el-button
      >
      <el-button @click="toggleSelection()">取消选择</el-button>
    </div> -->
    <div class="pagenum">
      <el-button size="mini" :disabled="firstPage" @click="goBack()" round
        >首页</el-button
      >
      <el-button size="mini" round :disabled="firstPage" @click="goPre()"
        >上一页</el-button
      >
      <el-button size="mini" round disabled>{{ pagesNum }}</el-button>
      <el-button size="mini" :disabled="lastPage" @click="goNext()" round
        >下一页</el-button
      >
      <el-button size="mini" :disabled="lastPage" @click="goLast()" round
        >尾页</el-button
      >
    </div>
    <!-- 编辑 -->
    <el-dialog
      title="编辑"
      :visible.sync="dialogEdit"
      width="30%"
      :before-close="handleClose"
    >
      <div class="newadditem">
        <span>属性名称：</span>
        <el-input v-model="changeName" placeholder="请输入属性名称"></el-input>
      </div>
      <div class="newadditem">
        <span>排序</span>
        <el-input
          v-model="changeSort"
          placeholder="请输入排序"
          oninput="value=value.replace(/[^\d]/g,'')"
        ></el-input>
      </div>
      <span slot="footer" class="dialog-footer">
        <el-button @click="dialogEdit = false">取 消</el-button>
        <el-button type="primary" @click="clickEdit"> 确 定 </el-button>
      </span>
    </el-dialog>
  </div>
</template>

<script>
  import { getList, addAttrbute, editAttrbute, delAttrbute } from "@/api/index";
  export default {
    data() {
      return {
        tableData: [],
        attributeName: "",
        attributeSort: "",
        changeName: "",
        changeSort: "",
        id: "",
        dialogVisible: false,
        dialogEdit: false,
        lastPage: false,
        pagesNum: 1,
        firstPage: false,
        lastPageNum: 1,
        falg: false,
      };
    },
    mounted() {
      this.getAttributeList(1);
    },
    methods: {
      // 返回首页
      goBack() {
        this.getAttributeList(1);
      },
      // 跳到尾页
      goLast() {
        this.getAttributeList(this.lastPageNum);
      },
      goNext() {
        this.getAttributeList(this.pagesNum + 1);
      },
      goPre() {
        this.getAttributeList(this.pagesNum - 1);
      },
      goSpeci(val) {
        const id = val.id;
        const attribute = val.name;
        console.log("val ->", val);
        this.$router.push({
          path: "/specification",
          query: {
            id,
            attribute,
          },
        });
      },
      // 添加
      clickAdd() {
        let data = {
          name: this.attributeName,
          sort: this.attributeSort,
        };
        if (this.attributeName && this.attributeSort) {
          addAttrbute(data).then((res) => {
            if (res.code == 0) {
              this.$message({
                type: "success",
                message: "添加成功!",
              });
              this.attributeName = "";
              this.attributeSort = "";
              this.$refs.multipleTable.tableData.length == 10
                ? this.getAttributeList(this.lastPageNum + 1)
                : this.getAttributeList(this.lastPageNum || 1);
            }
          });
          this.dialogVisible = false;
        } else {
          this.$message({
            type: "warning",
            message: "请填写完整!",
          });
        }
      },
      getAttributeList(num) {
        let data = {
          pageNum: num,
          pageSize: 10,
        };
        getList(data).then((res) => {
          this.tableData = res.data.elements;
          this.pagesNum = res.data.thisPageNumber;
          this.lastPageNum = res.data.totalPage || 1;
          if (res.data.lastElementNumber - res.data.firstElementNumber == 1) {
            this.falg = true;
          } else {
            this.falg = false;
          }
          console.log("this.flag ->", this.falg);
          if (res.data.lastPage) {
            this.lastPage = true;
          } else {
            this.lastPage = false;
          }
          if (res.data.thisPageNumber == 1) {
            this.firstPage = true;
          } else {
            this.firstPage = false;
          }
        });
      },
      handleClick(val) {
        this.id = val.id;
        this.dialogEdit = true;
      },
      //  编辑
      clickEdit() {
        let data = {
          name: this.changeName,
          sort: this.changeSort,
          id: this.id,
        };
        if (this.changeName && this.changeSort) {
          editAttrbute(data).then((res) => {
            console.log("res ->", res);
            if (res.code == 0) {
              this.$alert("更新成功", "提示", {
                confirmButtonText: "确定",
              });
              this.dialogEdit = false;
              this.getAttributeList(this.pagesNum);
            }
          });
        } else {
          this.$message({
            type: "warning",
            message: "请填写完整!",
          });
        }
      },
      delList(val) {
        this.id = val.id;
        this.$confirm("此操作将永久删除该属性, 是否继续?", "提示", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning",
        })
          .then(() => {
            delAttrbute({ id: this.id }).then((res) => {
              if (res.code == 0) {
                this.$message({
                  type: "success",
                  message: "删除成功!",
                });
                if (this.falg) {
                  console.log("222 ->", 222);
                  this.getAttributeList(this.pagesNum - 1);
                } else {
                  this.getAttributeList(this.pagesNum);
                }
              }
            });
          })
          .catch(() => {
            this.$message({
              type: "info",
              message: "已取消删除",
            });
          });
      },
      handleClose(done) {
        done();
      },
    },
  };
</script>
<style scoped>
  /deep/ .el-table__header-wrapper .el-checkbox {
    display: none;
  }
  .newadditem {
    margin: 10px 20px;
    display: flex;
    justify-content: space-between;
    align-items: center;
  }
  .newadditem > span {
    flex: 0 0 120px;
  }
  .pagenum {
    margin-top: 20px;
    display: flex;
    justify-content: flex-end;
  }
  .newadd {
    margin: 20px 0;
  }
</style>
