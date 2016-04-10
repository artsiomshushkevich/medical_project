<div class="modal user_add_modal fade" tabindex="-1" role="dialog">
    <div class="modal-dialog">
        <div class="modal-content">.

            <form method="post" action="users-add.action">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title">Add new user</h4>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <div class="form-group">
                            <label>Nickname: <input type="text" required class="form-control" name="user.nickname"></label>
                        </div>
                        <div class="form-group">
                            <label>Password: <input type="password" required  class="form-control" name="user.password"></label>
                        </div>
                        <div class="form-group">
                            <label>Role id: <input type="number" class="form-control"  required min="1" max="3" name="user.roleId"></label>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                        <button type="submit" class="btn btn-primary add-btn">Save</button>
                    </div>
                </div>
            </form>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->
