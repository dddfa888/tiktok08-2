<template>
  <div>
    <div class="newadd">
      <el-button type="primary" @click="() => $router.back()">返回</el-button>
      <el-button type="primary" @click="dialogVisible = true">
        新增规格
      </el-button>
    </div>
    <el-dialog
      title="规格名称"
      :visible.sync="dialogVisible"
      width="30%"
      :before-close="handleClose"
    >
      <el-tabs v-model="activeName" type="card" @tab-click="handleTabsClick">
        <el-tab-pane label="中文" name="cn">
          <div class="newadditem">
            <span>规格名称：</span>
            <el-input
              v-model="attributeName"
              placeholder="请输入属性名称"
            ></el-input>
          </div>
          <div class="newadditem">
            <span>所属属性</span>
            <el-input v-model="name" disabled></el-input>
          </div>
          <div class="newadditem">
            <span>排序</span>
            <el-input
              v-model="attributeSort"
              oninput="value=value.replace(/[^\d]/g,'')"
            ></el-input>
          </div>
          <div class="newadditem">
            <span>规格项</span>
            <el-input
              type="textarea"
              :rows="2"
              placeholder="请输入规格项，多个关键字用逗号隔开"
              v-model="textarea"
            >
            </el-input>
          </div>
        </el-tab-pane>
        <el-tab-pane label="英文" name="en">
          <div class="newadditem">
            <span>规格名称：</span>
            <el-input
              v-model="attributeNameEn"
              placeholder="请输入属性名称"
            ></el-input>
          </div>
          <div class="newadditem">
            <span>所属属性</span>
            <el-input v-model="name" disabled></el-input>
          </div>
          <div class="newadditem">
            <span>排序</span>
            <el-input
              v-model="attributeSortEn"
              oninput="value=value.replace(/[^\d]/g,'')"
            ></el-input>
          </div>
          <div class="newadditem">
            <span>规格项</span>
            <el-input
              type="textarea"
              :rows="2"
              placeholder="请输入规格项，多个关键字用逗号隔开"
              v-model="textareaEn"
            >
            </el-input>
          </div>
        </el-tab-pane>
        <el-tab-pane label="繁体" name="tw">
          <div class="newadditem">
            <span>规格名称：</span>
            <el-input
              v-model="attributeNameTw"
              placeholder="请输入属性名称"
            ></el-input>
          </div>
          <div class="newadditem">
            <span>所属属性</span>
            <el-input v-model="name" disabled></el-input>
          </div>
          <div class="newadditem">
            <span>排序</span>
            <el-input
              v-model="attributeSortTw"
              oninput="value=value.replace(/[^\d]/g,'')"
            ></el-input>
          </div>
          <div class="newadditem">
            <span>规格项</span>
            <el-input
              type="textarea"
              :rows="2"
              placeholder="请输入规格项，多个关键字用逗号隔开"
              v-model="textareaTw"
            >
            </el-input>
          </div>
        </el-tab-pane>
      </el-tabs>
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
      :key="id"
      :header-cell-style="{ background: '#e4e4e4' }"
    >
      <el-table-column type="selection" width="80" align="center">
      </el-table-column>
      <el-table-column label="规格ID" align="center">
        <template slot-scope="scope">{{ scope.row.id }}</template>
      </el-table-column>
      <el-table-column
        prop="attrName"
        label="规格名称"
        width="200"
        align="center"
      >
      </el-table-column>
      <el-table-column
        label="规格所属"
        prop="categoryName"
        width="200"
        align="center"
      >
      </el-table-column>
      <el-table-column prop="sort" label="排序" width="140" align="center">
      </el-table-column>
      <el-table-column prop="valueStr" label="设置" width="140" align="center">
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
      <el-tabs v-model="activeName" type="card" @tab-click="handleTabsClick">
        <el-tab-pane label="中文" name="cn">
          <div class="newadditem">
            <span>规格名称：</span>
            <el-input
              v-model="attributeName"
              placeholder="请输入属性名称"
            ></el-input>
          </div>
          <div class="newadditem">
            <span>所属属性</span>
            <el-input v-model="name" disabled></el-input>
          </div>
          <div class="newadditem">
            <span>排序</span>
            <el-input
              v-model="attributeSort"
              oninput="value=value.replace(/[^\d]/g,'')"
            ></el-input>
          </div>
          <div class="newadditem">
            <span>规格项</span>
            <el-input
              type="textarea"
              :rows="2"
              placeholder="请输入规格项，多个关键字用逗号隔开"
              v-model="textarea"
            >
            </el-input>
          </div>
        </el-tab-pane>
        <el-tab-pane label="英文" name="en">
          <div class="newadditem">
            <span>规格名称：</span>
            <el-input
              v-model="attributeNameEn"
              placeholder="请输入属性名称"
            ></el-input>
          </div>
          <div class="newadditem">
            <span>所属属性</span>
            <el-input v-model="name" disabled></el-input>
          </div>
          <div class="newadditem">
            <span>排序</span>
            <el-input
              v-model="attributeSortEn"
              oninput="value=value.replace(/[^\d]/g,'')"
            ></el-input>
          </div>
          <div class="newadditem">
            <span>规格项</span>
            <el-input
              type="textarea"
              :rows="2"
              placeholder="请输入规格项，多个关键字用逗号隔开"
              v-model="textareaEn"
            >
            </el-input>
          </div>
        </el-tab-pane>
        <el-tab-pane label="繁体" name="tw">
          <div class="newadditem">
            <span>规格名称：</span>
            <el-input
              v-model="attributeNameTw"
              placeholder="请输入属性名称"
            ></el-input>
          </div>
          <div class="newadditem">
            <span>所属属性</span>
            <el-input v-model="name" disabled></el-input>
          </div>
          <div class="newadditem">
            <span>排序</span>
            <el-input
              v-model="attributeSortTw"
              oninput="value=value.replace(/[^\d]/g,'')"
            ></el-input>
          </div>
          <div class="newadditem">
            <span>规格项</span>
            <el-input
              type="textarea"
              :rows="2"
              placeholder="请输入规格项，多个关键字用逗号隔开"
              v-model="textareaTw"
            >
            </el-input>
          </div>
        </el-tab-pane>
      </el-tabs>
      <span slot="footer" class="dialog-footer">
        <el-button @click="dialogEdit = false">取 消</el-button>
        <el-button type="primary" @click="clickEdit"> 确 定 </el-button>
      </span>
    </el-dialog>
  </div>
</template>

<script>
  import {
    speciList,
    addSpeci,
    editSpeci,
    deleteSpeci,
    updateSpeciInfo,
  } from "@/api/index";
  export default {
    name: "specification",
    data() {
      return {
        tableData: [],
        attributeName: "",
        textarea: "",
        name: "",
        attributeSort: "",
        attributeNameEn: "",
        textareaEn: "",
        nameEn: "",
        attributeSortEn: "",
        attributeNameTw: "",
        textareaTw: "",
        nameTw: "",
        attributeSortTw: "",
        changeName: "",
        changeSort: "",
        id: "",
        attributeId: "",
        dialogVisible: false,
        dialogEdit: false,
        lastPage: false,
        pagesNum: 1,
        firstPage: false,
        lastPageNum: 1,
        falg: false,
        activeName: "cn",
        lang: "cn",
      };
    },
    activated() {
      this.getAttributeList(1, this.attributeId);
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
      handleTabsClick(tab) {
        tab.index == 0 ? (this.lang = "cn") : (this.lang = "en");
      },
      // 添加
      clickAdd() {
        let data = {
          ["cn"]: {
            categoryId: this.attributeId,
            name: this.attributeName,
            values: this.textarea,
            lang: "cn",
            sort: this.attributeSort,
          },
          ["en"]: {
            categoryId: this.attributeId,
            name: this.attributeNameEn,
            values: this.textareaEn,
            sort: this.attributeSortEn,
            lang: "en",
          },
          ["tw"]: {
            categoryId: this.attributeId,
            name: this.attributeNameTw,
            values: this.textareaTw,
            sort: this.attributeSortTw,
            lang: "tw",
          },
        };
        if (
          this.attributeName &&
          this.textarea &&
          this.attributeSortEn &&
          this.attributeNameEn &&
          this.textareaEn &&
          this.attributeSort &&
          this.attributeNameTw &&
          this.textareaTw &&
          this.attributeSortTw
        ) {
          addSpeci(data).then((res) => {
            if (res.code == 0) {
              this.$message({
                type: "success",
                message: "添加成功!",
              });
              console.log("res ->", res);
              this.attributeName = "";
              this.textarea = "";
              this.attributeSort = "";
              this.getAttributeList(this.lastPageNum);
              this.dialogVisible = false;
            }
          });
        } else {
          this.$message({
            type: "warning",
            message: "请填写完整!",
          });
        }
      },
      getAttributeList(num) {
        this.attributeId = this.$route.query.id;
        this.name = this.$route.query.attribute;
        let data = {
          pageNum: num,
          pageSize: 10,
          categoryId: this.attributeId,
        };
        speciList(data).then((res) => {
          console.log("res ->", res);
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
        // let lang = this.lang;
        updateSpeciInfo({ id: this.id }).then((res) => {
          // if (lang == "cn") {
          this.attributeName = res.data.cn.name;
          this.textarea = res.data.cn.values;
          this.attributeSort = res.data.cn.sort;

          this.attributeNameEn = res.data.en.name;
          this.textareaEn = res.data.en.values;
          this.attributeSortEn = res.data.en.sort;

          this.attributeNameTw = res.data.tw.name;
          this.textareaTw = res.data.tw.values;
          this.attributeSortTw = res.data.tw.sort;
          // } else {

          // }
        });
      },
      //  编辑
      clickEdit() {
        let data = {
          ["cn"]: {
            categoryId: this.attributeId,
            id: this.id,
            name: this.attributeName,
            values: this.textarea,
            sort: this.attributeSort,
            lang: "cn",
          },
          ["en"]: {
            categoryId: this.attributeId,
            id: this.id,
            name: this.attributeNameEn,
            values: this.textareaEn,
            sort: this.attributeSortEn,
            lang: "en",
          },
          ["tw"]: {
            categoryId: this.attributeId,
            id: this.id,
            name: this.attributeNameTw,
            values: this.textareaTw,
            sort: this.attributeSortTw,
            lang: "tw",
          },
        };
        if (
          this.attributeName &&
          this.textarea &&
          this.attributeSortEn &&
          this.attributeNameEn &&
          this.textareaEn &&
          this.attributeSort &&
          this.attributeNameTw &&
          this.textareaTw &&
          this.attributeSortTw
        ) {
          editSpeci(data).then((res) => {
            if (res.code == 0) {
              this.$alert("更新成功", "提示", {
                confirmButtonText: "确定",
              });
              this.dialogEdit = false;
              this.attributeName = "";
              this.textarea = "";
              this.attributeSort = "";
              this.attributeNameEn = "";
              this.textareaEn = "";
              this.attributeSortEn = "";
              this.attributeNameTw = "";
              this.textareaTw = "";
              this.attributeSortTw = "";
              this.$refs.multipleTable.tableData.length == 10
                ? this.getAttributeList(this.pagesNum + 1)
                : this.getAttributeList(this.pagesNum);
            }
          });
        } else {
          this.dialogEdit = false;
          this.attributeName = "";
          this.textarea = "";
          this.attributeSort = "";
          this.attributeNameEn = "";
          this.textareaEn = "";
          this.attributeSortEn = "";
          this.attributeNameTw = "";
          this.textareaTw = "";
          this.attributeSortTw = "";
          this.$message({
            type: "warning",
            message: "请填写完整!",
          });
        }
      },
      delList(val) {
        console.log("this.$refs.multipleTable ->");
        this.id = val.id;
        this.$confirm("此操作将永久删除该规格, 是否继续?", "提示", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning",
        })
          .then(() => {
            deleteSpeci({ id: this.id }).then((res) => {
              if (res.code == 0) {
                this.$message({
                  type: "success",
                  message: "删除成功!",
                });
                this.$refs.multipleTable.tableData.length == 1
                  ? this.getAttributeList(this.pagesNum - 1)
                  : this.getAttributeList(this.pagesNum);
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
        this.attributeName = "";
        this.textarea = "";
        this.attributeSort = "";
        this.attributeNameEn = "";
        this.textareaEn = "";
        this.attributeSortEn = "";
        this.attributeNameTw = "";
        this.textareaTw = "";
        this.attributeSortTw = "";
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
