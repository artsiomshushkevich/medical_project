<div class="modal orders_edit_modal fade" tabindex="-1" role="dialog">
    <div class="modal-dialog">
        <div class="modal-content">.

            <form method="post" action="orders-update.action">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title">Update order info</h4>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <input id="orders_edit_id" name="order.id" type="hidden">
                        <div class="form-group">
                            <label>Client:
                                <select required class="form-control" name="order.clientId">
                                    <s:iterator value="clientsList" var="client">
                                        <option value="<s:property value="id"></s:property>">
                                            <s:property value="getFullname()"></s:property>
                                        </option>
                                    </s:iterator>
                                </select>
                            </label>
                        </div>
                        <div class="form-group">
                            <label>Date: <input type="date" required class="form-control" name="date"></label>
                        </div>
                        <div class="form-group">
                            <label>Doctor:
                                <select required class="form-control" name="order.doctorId">
                                    <s:iterator value="doctorsList" var="doctor">
                                        <option value="<s:property value="id"></s:property>">
                                            <s:property value="getFullname()"></s:property>
                                        </option>
                                    </s:iterator>
                                </select>
                            </label>
                        </div>
                        <div class="form-group">
                            <label>Begin time: <input type="time" required class="form-control" name="time"></label>
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