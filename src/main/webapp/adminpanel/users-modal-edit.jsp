<div class="modal user_edit_modal fade" tabindex="-1" role="dialog">
    <div class="modal-dialog">
        <div class="modal-content">.

            <form method="post" action="users-update.action">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title">Update user info</h4>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <input id="user_edit_id" name="user.id" type="hidden">
                        <div class="form-group">
                            <label>Nickname: <input type="text" required class="form-control" name="user.nickname"></label>
                        </div>
                        <div class="form-group">
                            <label>Password: <input type="password" required class="form-control" name="user.password"></label>
                        </div>
                        <div class="form-group">
                            <label>Role:
                                <select required class="form-control" name="user.roleId">
                                    <s:iterator value="rolesList" var="role">
                                        <option value="<s:property value="id"></s:property>">
                                            <s:property value="name"></s:property>
                                        </option>
                                    </s:iterator>
                                </select>
                            </label>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                        <button type="submit" class="btn btn-primary add-btn">Save changes</button>
                    </div>
                </div>
            </form>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->
